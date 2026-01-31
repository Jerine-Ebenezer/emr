package com.emr.application.Services;


import com.emr.application.Entities.MedicalHistory;
import com.emr.application.Entities.Patient;
import com.emr.application.Repositories.MedHistoryRepository;
import com.emr.application.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedHistoryService {

    @Autowired
    private MedHistoryRepository medHistoryRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void addMedHistory(MedicalHistory request) {
        if (request.getPatient() == null || request.getPatient().getId() == null) {
            throw new RuntimeException("Patient ID is required");
        }

        // fetch patient from DB
        Patient patient = patientRepository.findById(request.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // set the patient object
        request.setPatient(patient);

        // save medical history
        medHistoryRepository.save(request);
    }

    public MedicalHistory selectById(String code) {
        // fetch patient by code
        Patient patient = patientRepository.findByPatientId(code).orElseThrow(() -> new RuntimeException("Patient not found"));

        // fetch medical history for that patient
        return medHistoryRepository.findByPatient(patient).orElse(new MedicalHistory()); // or throw exception if not found
    }

    public List<MedicalHistory> getAll() {
        return medHistoryRepository.findAll();
    }

    public String delete() {
        medHistoryRepository.deleteAll();
        return "Deleted successfully";
    }

}
