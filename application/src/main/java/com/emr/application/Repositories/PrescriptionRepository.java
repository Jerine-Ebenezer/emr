package com.emr.application.Repositories;
import com.emr.application.Entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository  extends JpaRepository<Prescription,Long> {

    List<Prescription> findByPatient_PatientId(String patientId);
}
