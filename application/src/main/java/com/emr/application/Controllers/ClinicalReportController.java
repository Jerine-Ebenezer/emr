package com.emr.application.Controllers;

import com.emr.application.Entities.ClinicalReport;

import com.emr.application.Services.ClinicalReportService;
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
@RequestMapping("/api/clinical-reports")
public class ClinicalReportController {

    @Autowired
    private ClinicalReportService reportService;

    @PostMapping
    public ResponseEntity<String> addReport(@RequestBody ClinicalReport report, @RequestParam String patientCode) {
        reportService.addReport(report, patientCode);
        return ResponseEntity.status(HttpStatus.CREATED).body("Clinical report saved successfully");
    }

    @GetMapping("/{patientCode}")
    public ResponseEntity<List<ClinicalReport>> getReports(@PathVariable String patientCode) {
        List<ClinicalReport> reports = reportService.getReportsByPatient(patientCode);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClinicalReport>> getAllReports() {
        List<ClinicalReport> reports = reportService.getAllReports(); // you need to implement this
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public String deleteReports() {
        return reportService.delete();
    }
}
