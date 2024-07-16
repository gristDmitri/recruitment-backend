package de.immocloud.recruiting.jpa.repositories;

import de.immocloud.recruiting.jpa.repositories.models.Applicant;
import de.immocloud.recruiting.jpa.repositories.models.enums.ApplicantStatus;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends MongoRepository<Applicant, ObjectId> {
    @Query("{ 'name': { $regex: ?0, $options: 'i' }, 'status': { $ne: ?1 } }")
    List<Applicant> findFiltered(String likeName, ApplicantStatus excludedStatus);
}
