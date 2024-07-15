package de.immocloud.recruiting.services;

import de.immocloud.recruiting.exceptions.ApplicantNotFoundException;
import de.immocloud.recruiting.jpa.repositories.ApplicantRepository;
import de.immocloud.recruiting.jpa.repositories.models.Applicant;
import de.immocloud.recruiting.mappers.ApplicantMapper;
import de.immocloud.recruiting.web.rest.dtos.ApplicantDto;
import de.immocloud.recruiting.web.rest.dtos.StoreApplicantDto;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    public ApplicantService(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper) {
        this.applicantRepository = applicantRepository;
        this.applicantMapper = applicantMapper;
    }

    public List<ApplicantDto> getAllApplicants() {
        return applicantMapper.modelsToDtos(applicantRepository.findAll());
    }

    public ApplicantDto getApplicantById(ObjectId id) {
        return applicantMapper.modelToDto(applicantRepository.findById(id).orElseThrow(() -> new ApplicantNotFoundException(id)));
    }

    public ApplicantDto createApplicant(StoreApplicantDto applicantDto) {
        Applicant createdApplicant = applicantRepository.save(applicantMapper.dtoToModel(applicantDto));
        return applicantMapper.modelToDto(createdApplicant);
    }

    public ApplicantDto updateApplicant(ObjectId id, StoreApplicantDto storeApplicantDto) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new ApplicantNotFoundException(id));

        Applicant updatedApplicant = applicantRepository.save(applicantMapper.update(applicant, storeApplicantDto));

        return applicantMapper.modelToDto(updatedApplicant);
    }

    public void deleteApplicant(ObjectId id) {
        if(!applicantRepository.existsById(id)) {
            throw new ApplicantNotFoundException(id);
        }

        applicantRepository.deleteById(id);
    }
}
