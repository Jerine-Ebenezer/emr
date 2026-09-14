package com.emr.application.Controllers;

import com.emr.application.Entities.Prescription;
import com.emr.application.Services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "https://emr-amber-beta.vercel.app"
})
@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<String> addPrescription(@RequestBody Prescription prescription, @RequestParam String patientCode) {
        prescriptionService.addPrescription(prescription, patientCode);
        return ResponseEntity.status(HttpStatus.CREATED).body("Prescription saved successfully");
    }

    @GetMapping("/{patientCode}")
    public ResponseEntity<List<Prescription>> getPrescriptions(@PathVariable String patientCode) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatient(patientCode);
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {
        return prescriptionService.delete();
    }
}
