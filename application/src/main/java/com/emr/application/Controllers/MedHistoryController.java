//package com.emr.application.Controllers;
//
//import com.emr.application.Services.MedHistoryService;
//import com.emr.application.Entities.MedicalHistory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//@CrossOrigin(origins = "http://127.0.0.1:5500")
//@RestController
//@RequestMapping("/api/med-history")
//public class MedHistoryController {
//@Autowired
//private MedHistoryService medHistoryService;
// @GetMapping("/show/medHistory/{code}")
//public ResponseEntity<MedicalHistory> historyById(@PathVariable String code){
//     return  new ResponseEntity<>(medHistoryService.selectById(code),HttpStatus.OK);
// }
//
//    @PostMapping("/api/medical-history")
//    public ResponseEntity<String> addMedHistory(@RequestBody MedicalHistory medicalHistory) {
//        medHistoryService.addMedHistory(medicalHistory);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Medical history saved successfully");
//    }
//
//}
package com.emr.application.Controllers;

import com.emr.application.Services.MedHistoryService;
import com.emr.application.Entities.MedicalHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController

@RequestMapping("/api/med-history")
public class MedHistoryController {

    @Autowired
    private MedHistoryService medHistoryService;

    @GetMapping("/{code}")
    public ResponseEntity<MedicalHistory> historyById(@PathVariable String code) {
        return new ResponseEntity<>(medHistoryService.selectById(code), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicalHistory>> getAll() {
        return ResponseEntity.ok(medHistoryService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> addMedHistory(@RequestBody MedicalHistory medicalHistory) {
        medHistoryService.addMedHistory(medicalHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medical history saved successfully");
    }

    @DeleteMapping("/delete/all")
    public String deleteReports() {
        return medHistoryService.delete();
    }
}
