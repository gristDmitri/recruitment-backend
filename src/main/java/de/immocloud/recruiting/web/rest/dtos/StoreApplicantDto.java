package de.immocloud.recruiting.web.rest.dtos;

import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;

public record StoreApplicantDto(String name,
                                ApplicantStatus status) {
}
