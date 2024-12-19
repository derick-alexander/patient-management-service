package com.cmm707.meditrack.patient_management_service.controller;


import com.cmm707.meditrack.patient_management_service.model.Patient;
import com.cmm707.meditrack.patient_management_service.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing patient records.
 */
@Slf4j
@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    /**
     * API endpoint to create a new patient record.
     * @param patient Patient data.
     * @return ResponseEntity with the created Patient entity.
     */
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        log.info("API call to create a new patient");
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    /**
     * API endpoint to update an existing patient record.
     * @param id ID of the patient to update.
     * @param patient Updated patient data.
     * @return ResponseEntity with the updated Patient entity.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient patient) {
        log.info("API call to update patient with ID: {}", id);
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    /**
     * API endpoint to retrieve a patient record by ID.
     * @param id ID of the patient.
     * @return ResponseEntity with the Patient entity.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        log.info("API call to fetch patient with ID: {}", id);
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    /**
     * API endpoint to retrieve all patient records.
     * @return ResponseEntity with a list of all Patient entities.
     */
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        log.info("API call to fetch all patients");
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    /**
     * API endpoint to delete a patient record by ID.
     * @param id ID of the patient to delete.
     * @return ResponseEntity with no content on success.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        log.info("API call to delete patient with ID: {}", id);
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
