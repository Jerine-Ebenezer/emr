package com.emr.application.Services;

import com.emr.application.Entities.Patient;
import com.emr.application.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> showAllPatients() {
        return patientRepository.findAll();
    }

    public String delete() {
        patientRepository.deleteAll();
        return "deleted Successfully";
    }
}
