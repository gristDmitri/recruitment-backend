package de.immocloud.recruiting.services;

import de.immocloud.recruiting.exceptions.ApplicantNotFoundException;
import de.immocloud.recruiting.jpa.repositories.ApplicantRepository;
import de.immocloud.recruiting.jpa.repositories.models.Applicant;
import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;
import de.immocloud.recruiting.mappers.ApplicantMapper;
import de.immocloud.recruiting.web.rest.dtos.ApplicantCreateDto;
import de.immocloud.recruiting.web.rest.dtos.ApplicantDto;
import de.immocloud.recruiting.web.rest.dtos.ApplicantPatchDto;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    public ApplicantService(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper) {
        this.applicantRepository = applicantRepository;
        this.applicantMapper = applicantMapper;
    }

    public List<ApplicantDto> findApplicants(String name, ApplicantStatus status) {
        return applicantMapper.modelsToDtos(applicantRepository.findFiltered(name, status));
    }

    public ApplicantDto createApplicant(ApplicantCreateDto applicantDto) {
        Applicant createdApplicant = applicantRepository.save(applicantMapper.dtoToModel(applicantDto));
        return applicantMapper.modelToDto(createdApplicant);
    }

    public ApplicantDto patchApplicant(ObjectId id, ApplicantPatchDto applicantPatchDto) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ApplicantNotFoundException(id));

        Applicant updatedApplicant = applicantRepository.save(applicantMapper.patch(applicant, applicantPatchDto));

        return applicantMapper.modelToDto(updatedApplicant);
    }
}
