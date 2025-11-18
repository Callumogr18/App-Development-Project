package com.example.project.dto;

import com.example.project.dto.MoonDTO;
import com.example.project.entity.Moon;
import org.springframework.stereotype.Component;

@Component
public class MoonMapper {
    public MoonDTO toMoonDTO(Moon moon) {
        return new MoonDTO(
                moon.getMoonId(),
                moon.getMoonName(),
                moon.getDiameterKm(),
                moon.getOrbitalPeriodDays(),
                moon.getPlanet().getPlanetId()
        );
    }
}