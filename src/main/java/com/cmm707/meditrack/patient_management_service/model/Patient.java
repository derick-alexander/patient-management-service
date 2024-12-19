package com.cmm707.meditrack.patient_management_service.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity class representing the patient data stored in the database.
 */
@Data
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String patientIdentifier;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private List<String> medicalHistory;
    private List<String> prescriptions;
    private List<String> labResults;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
