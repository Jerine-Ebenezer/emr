package com.emr.application.Controllers;


import com.emr.application.Services.DiseaseService;
import com.emr.application.Entities.Diseases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin(origins = {

        "http://127.0.0.1:5500",
        "https://emr-406bs8l5h-jer20.vercel.app",
        "https://emr-amber-beta.vercel.app",
        "https://emr-pxjzewzl0-jer20.vercel.app"
})
@RestController
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/showAll/disease")
    public ResponseEntity<List<Diseases>> DiseaseAvailable() {
        return new ResponseEntity<>(diseaseService.showDisease(), HttpStatus.FOUND);
    }

    @PostMapping("/add/disease")
    public void AddDisease(@RequestBody Diseases diseases) {
        diseaseService.addDisease(diseases);
    }

    @GetMapping("search/by/{id}")
    public Diseases searchById(@PathVariable Long id) {
        try {
            return diseaseService.searchByCode(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/searchByName")
    public List<Diseases> searchByName(@RequestParam String name) {
        if (name == null || name.isEmpty()) return List.of();
        return diseaseService.searchByName(name);
    }
}
