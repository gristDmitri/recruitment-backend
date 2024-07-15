package de.immocloud.recruiting.exceptions;

import org.bson.types.ObjectId;

public class ApplicantNotFoundException extends RuntimeException {
    public ApplicantNotFoundException(ObjectId id) {
        super("Could not find applicant with id " + id);
    }
}
