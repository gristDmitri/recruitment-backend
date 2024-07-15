package de.immocloud.recruiting.mappers;

import de.immocloud.recruiting.jpa.repositories.models.Applicant;
import de.immocloud.recruiting.web.rest.dtos.ApplicantDto;
import de.immocloud.recruiting.web.rest.dtos.StoreApplicantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicantMapper {
    ApplicantDto modelToDto(Applicant applicant);

    @Mapping(target = "id", ignore = true)
    Applicant dtoToModel(StoreApplicantDto storeApplicantDto);

    List<ApplicantDto> modelsToDtos(List<Applicant> applicants);

    List<Applicant> dtosToModels(List<ApplicantDto> applicantDtos);

    @Mapping(target = "id", ignore = true)
    Applicant update(@MappingTarget Applicant applicant, StoreApplicantDto applicantDto);
}
