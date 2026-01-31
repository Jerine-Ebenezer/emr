package com.emr.application.Services;

import com.emr.application.Entities.Patient;
import com.emr.application.Entities.Prescription;
import com.emr.application.Repositories.PatientRepository;
import com.emr.application.Repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void addPrescription(Prescription prescription, String patientCode) {
        Patient patient = patientRepository.findByPatientId(patientCode)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        prescription.setPatient(patient);
        prescriptionRepository.save(prescription);
    }

    public List<Prescription> getPrescriptionsByPatient(String patientCode) {
        return prescriptionRepository.findByPatient_PatientId(patientCode);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public String delete() {
        prescriptionRepository.deleteAll();
        return "successfully deleted";
    }
}
