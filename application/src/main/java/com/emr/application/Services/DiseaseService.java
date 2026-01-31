package com.emr.application.Services;

import com.emr.application.Entities.Diseases;
import com.emr.application.Repositories.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    public void addDisease(Diseases diseases) {
        diseaseRepository.save(diseases);
    }

    public List<Diseases> showDisease() {
        return diseaseRepository.findAll();
    }

    public Diseases searchByCode(Long id) {
        return diseaseRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found!"));
    }

    public List<Diseases> searchByName(String name) {
        return diseaseRepository.findByNameContaining(name);
    }
}
