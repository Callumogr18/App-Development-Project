package com.example.project.repository;

import com.example.project.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepo extends JpaRepository<Planet, Long> {
    // Custom query method to find planets by type
    List<Planet> findByPlanetType(String planetType);
}
