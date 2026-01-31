package com.emr.application.Services;


import com.emr.application.Entities.LabReport;
import com.emr.application.Entities.Patient;
import com.emr.application.Repositories.LabReportRepository;
import com.emr.application.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabReportService {

    @Autowired
    private LabReportRepository labReportRepository;

    @Autowired
    private PatientRepository patientRepository;
    public  void addLabReport(LabReport labReport, String patientCode){
        Patient p = patientRepository.findByPatientId(patientCode).orElseThrow(()-> new RuntimeException("Patient not found"));
        labReport.setPatient(p);
        labReportRepository.save(labReport);
    }

    public List<LabReport> getLabReports(String patientCode){
        return labReportRepository.findByPatient_PatientId(patientCode);
    }
    public List<LabReport> getAll() {
        return labReportRepository.findAll();
    }
    public String delete(){
        labReportRepository.deleteAll();
        return "deleted Successfully";
    }
}
