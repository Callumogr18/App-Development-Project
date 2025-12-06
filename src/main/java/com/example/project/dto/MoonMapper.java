package com.example.project.dto;

import com.example.project.entity.Moon;
import com.example.project.entity.Planet;
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

    public Moon toEntity(MoonDTO moonDTO, Planet planet) {
        Moon moon = new Moon();
        moon.setMoonId(moonDTO.getMoonId());
        moon.setName(moonDTO.getName());
        moon.setDiameterKm(moonDTO.getDiameterKm());
        moon.setOrbitalPeriodDays(moonDTO.getOrbitalPeriodDays());
        moon.setPlanet(planet);
        return moon;
    }
}