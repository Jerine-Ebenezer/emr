package com.emr.application.Controllers;

import com.emr.application.Entities.Patient;
import com.emr.application.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "https://emr-amber-beta.vercel.app",
        "https://emr-pxjzewzl0-jer20.vercel.app"
})
@RestController

public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping({"/add/patients"})
    public void addingPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @GetMapping("/api/patients")
    public ResponseEntity<List<Patient>> showAll() {
        return new ResponseEntity<>(patientService.showAllPatients(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public String deleteReports() {
        return patientService.delete();
    }
}
