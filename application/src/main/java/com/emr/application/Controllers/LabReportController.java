package com.emr.application.Controllers;


import com.emr.application.Entities.LabReport;
import com.emr.application.Services.LabReportService;
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
@RequestMapping("/api/lab-reports")

public class LabReportController {

    @Autowired
    private LabReportService labReportService;


    @PostMapping
    public ResponseEntity<String> addReport(@RequestBody LabReport labReport, @RequestParam String patientCode) {
        labReportService.addLabReport(labReport, patientCode);
        return ResponseEntity.status(HttpStatus.CREATED).body("Lab report saved successfully");
    }

    @GetMapping("/{patientCode}")
    public ResponseEntity<List<LabReport>> getReports(@PathVariable String patientCode) {
        List<LabReport> reports = labReportService.getLabReports(patientCode);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LabReport>> getAllReports() {
        return new ResponseEntity<>(labReportService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public String deleteReports() {
        return labReportService.delete();
    }
}
