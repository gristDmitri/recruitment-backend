package de.immocloud.recruiting.web.rest.dtos;

import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;
import jakarta.validation.constraints.NotEmpty;

public record ApplicantCreateDto(@NotEmpty String name,
                                 @NotEmpty ApplicantStatus status) {
}
