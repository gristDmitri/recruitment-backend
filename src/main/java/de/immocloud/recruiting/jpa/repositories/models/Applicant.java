package de.immocloud.recruiting.jpa.repositories.models;

import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Applicant {
    private @Id ObjectId id;
    private String name;
    private ApplicantStatus status;

    public Applicant() {
    }

    public Applicant(ObjectId id, String name, ApplicantStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicantStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicantStatus status) {
        this.status = status;
    }
}
