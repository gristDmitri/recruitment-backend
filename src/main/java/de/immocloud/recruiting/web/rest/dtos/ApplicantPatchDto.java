package de.immocloud.recruiting.web.rest.dtos;

import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;

public record ApplicantPatchDto(String name,
                                ApplicantStatus status) {
}
