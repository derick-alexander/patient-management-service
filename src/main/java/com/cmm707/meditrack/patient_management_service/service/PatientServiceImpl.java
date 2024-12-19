package com.cmm707.meditrack.patient_management_service.service;

import com.cmm707.meditrack.patient_management_service.model.Patient;
import com.cmm707.meditrack.patient_management_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing patient records.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    /**
     * Creates a new patient record.
     * @param patient Patient data to be stored.
     * @return The created Patient entity.
     */
    @Override
    public Patient createPatient(Patient patient) {
        log.info("Creating new patient record: {}", patient.getName());
        return patientRepository.save(patient);
    }

    /**
     * Updates an existing patient record by ID.
     * @param id ID of the patient to update.
     * @param patient Updated patient data.
     * @return The updated Patient entity.
     */
    @Override
    public Patient updatePatient(String id, Patient patient) {
        log.info("Updating patient record with ID: {}", id);
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            patient.setId(id); // Set ID to ensure the same record is updated.
            return patientRepository.save(patient);
        } else {
            log.warn("Patient record not found with ID: {}", id);
            throw new RuntimeException("Patient not found");
        }
    }

    /**
     * Retrieves a patient record by ID.
     * @param id ID of the patient.
     * @return The Patient entity if found.
     */
    @Override
    public Patient getPatientById(String id) {
        log.info("Fetching patient record with ID: {}", id);
        return patientRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Patient not found with ID: {}", id);
                    return new RuntimeException("Patient not found");
                });
    }

    /**
     * Retrieves all patient records.
     * @return List of all Patient entities.
     */
    @Override
    public List<Patient> getAllPatients() {
        log.info("Fetching all patient records");
        return patientRepository.findAll();
    }

    /**
     * Deletes a patient record by ID.
     * @param id ID of the patient to delete.
     */
    @Override
    public void deletePatient(String id) {
        log.info("Deleting patient record with ID: {}", id);
        patientRepository.deleteById(id);
    }
}
