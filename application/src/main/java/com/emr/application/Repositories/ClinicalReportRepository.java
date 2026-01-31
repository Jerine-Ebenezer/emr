package com.emr.application.Repositories;


import com.emr.application.Entities.ClinicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicalReportRepository extends JpaRepository<ClinicalReport, Long> {
    List<ClinicalReport> findByPatient_PatientId(String patientId);

}

