package com.cmm707.meditrack.patient_management_service.service;

import com.cmm707.meditrack.patient_management_service.model.Patient;

import java.util.List;

/**
 * Service interface defining methods for managing patient records.
 */
public interface PatientService {
    /**
     * Creates a new patient record.
     * @param patient Patient data to be stored.
     * @return The created Patient entity.
     */
    Patient createPatient(Patient patient);

    /**
     * Updates an existing patient record.
     * @param id ID of the patient to update.
     * @param patient Updated patient data.
     * @return The updated Patient entity.
     */
    Patient updatePatient(String id, Patient patient);

    /**
     * Retrieves a patient record by ID.
     * @param id ID of the patient.
     * @return The Patient entity if found.
     */
    Patient getPatientById(String id);

    /**
     * Retrieves all patient records.
     * @return List of all Patient entities.
     */
    List<Patient> getAllPatients();

    /**
     * Deletes a patient record by ID.
     * @param id ID of the patient to delete.
     */
    void deletePatient(String id);
}
