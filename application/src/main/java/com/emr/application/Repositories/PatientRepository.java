package com.emr.application.Repositories;

import com.emr.application.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {


        Optional<Patient> findByPatientId(String patientId); // patient code like P001


}
