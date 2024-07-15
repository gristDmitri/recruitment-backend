package de.immocloud.recruiting.web.rest.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;
import org.bson.types.ObjectId;

public record ApplicantDto(@JsonSerialize(using = ToStringSerializer.class) ObjectId id,
                           String name,
                           ApplicantStatus status) {
}
