package de.immocloud.recruiting.jpa.repositories;

import de.immocloud.recruiting.jpa.repositories.models.Applicant;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicantRepository extends MongoRepository<Applicant, ObjectId> {
}
