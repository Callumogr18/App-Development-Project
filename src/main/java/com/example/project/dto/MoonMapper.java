package com.example.project.dto;

import com.example.project.entity.Moon;
import org.springframework.stereotype.Component;

@Component
public class MoonMapper {
    public MoonDTO toMoonDTO(Moon moon) {
        return new MoonDTO(
                moon.getMoonId(),
                moon.getName(),
                moon.getDiameterKm(),
                moon.getOrbitalPeriodDays(),
                moon.getPlanet().getPlanetId()
        );
    }
}