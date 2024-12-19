package com.cmm707.meditrack.patient_management_service.repository;

import com.cmm707.meditrack.patient_management_service.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Patient entities in MongoDB.
 */
@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
}
