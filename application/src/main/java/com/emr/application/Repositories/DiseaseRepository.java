package com.emr.application.Repositories;

import com.emr.application.Entities.Diseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Diseases,Long> {
    @Query("SELECT d FROM Diseases d WHERE LOWER(d.diseaseName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Diseases> findByNameContaining(@Param("name") String name);
}
