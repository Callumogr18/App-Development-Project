package com.example.project.repository;

import com.example.project.entity.Moon;
import com.example.project.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoonRepository extends JpaRepository<Moon, Long> {
    // Find all moons for a specific planet by planet ID
    List<Moon> findByPlanetPlanetId(Long planetId);

    // Find all moons for a specific planet by planet name
    List<Moon> findByPlanetPlanetName(String planetName);

    // Count moons for a specific planet by planet ID
    long countByPlanetPlanetId(Long planetId);

    // Count moons for a specific planet by planet name
    long countByPlanetPlanetName(String planetName);
}
