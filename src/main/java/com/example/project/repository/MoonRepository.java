package com.example.project.repository;

import com.example.project.entity.Moon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoonRepository extends JpaRepository<Moon, Long> {
    // Find all moons for a specific planet by planet ID
    List<Moon> findByPlanetPlanetId(Long planetId);

    // Find all moons for a specific planet by planet name
    @Query("SELECT m FROM Moon m WHERE m.planet.planetName = :planetName")
    List<Moon> findByPlanetName(String planetName);

    // Count moons for a specific planet by planet ID
    @Query("SELECT COUNT(m) FROM Moon m WHERE m.planet.planetId = :planetId")
    long countByPlanetId(Long planetId);

    // Count moons for a specific planet by planet name
    @Query("SELECT COUNT(m) FROM Moon m WHERE m.planet.planetName = :planetName")
    long countByPlanetName(String planetName);
}
