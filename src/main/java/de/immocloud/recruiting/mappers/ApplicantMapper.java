package de.immocloud.recruiting.mappers;

import de.immocloud.recruiting.jpa.repositories.models.Applicant;
import de.immocloud.recruiting.web.rest.dtos.ApplicantDto;
import de.immocloud.recruiting.web.rest.dtos.ApplicantCreateDto;
import de.immocloud.recruiting.web.rest.dtos.ApplicantPatchDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicantMapper {
    ApplicantDto modelToDto(Applicant applicant);

    @Mapping(target = "id", ignore = true)
    Applicant dtoToModel(ApplicantCreateDto applicantCreateDto);

    List<ApplicantDto> modelsToDtos(List<Applicant> applicants);

    @Mapping(target = "id", ignore = true)
    Applicant patch(@MappingTarget Applicant applicant, ApplicantPatchDto applicantDto);
}
