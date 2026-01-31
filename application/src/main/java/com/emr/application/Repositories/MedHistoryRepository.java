package com.emr.application.Repositories;

import com.emr.application.Entities.Patient;
import com.emr.application.Entities.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedHistoryRepository extends JpaRepository<MedicalHistory,Long> {
    Optional<MedicalHistory> findByPatient(Patient patient);
}
