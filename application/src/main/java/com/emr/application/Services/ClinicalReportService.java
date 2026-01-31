package com.emr.application.Services;

import com.emr.application.Entities.ClinicalReport;
import com.emr.application.Entities.Patient;
import com.emr.application.Repositories.ClinicalReportRepository;
import com.emr.application.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalReportService {

    @Autowired
    private ClinicalReportRepository clinicalReportRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void addReport(ClinicalReport report, String patientCode) {
        Patient patient = patientRepository.findByPatientId(patientCode)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        report.setPatient(patient);
        clinicalReportRepository.save(report);
    }

    public List<ClinicalReport> getReportsByPatient(String patientCode) {
        return clinicalReportRepository.findByPatient_PatientId(patientCode);
    }

    public List<ClinicalReport> getAllReports() {
        return clinicalReportRepository.findAll();
    }

    public String delete() {
        clinicalReportRepository.deleteAll();
        return "deleted successfully";
    }
}

