package com.example.project.service;

import com.example.project.dto.PlanetDTO;
import com.example.project.entity.Planet;

import java.util.List;

public interface PlanetService {
    PlanetDTO addPlanet(PlanetDTO planetDTO);
    List<PlanetDTO> getAllPlanets();
    PlanetDTO getPlanetById(Long id);
    PlanetDTO updatePlanet(Long id, PlanetDTO planetDTO);
    void deletePlanet(Long id);
    List<PlanetDTO> getPlanetsByType(String type);
}
