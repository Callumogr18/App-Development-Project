package com.example.project.service;

import com.example.project.dto.MoonDTO;

import java.util.List;

public interface MoonService {
    MoonDTO addMoon(MoonDTO moonDTO);
    List<MoonDTO> getAllMoons();
    MoonDTO getMoonById(Long id);
    void deleteMoon(Long id);
    List<MoonDTO> getMoonsByPlanetName(String planetName);
    long countMoonsByPlanetName(String planetName);
}
