package com.emr.application.Repositories;

import com.emr.application.Entities.LabReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabReportRepository  extends JpaRepository<LabReport,Long> {


    List<LabReport> findByPatient_PatientId(String patientId);

}
