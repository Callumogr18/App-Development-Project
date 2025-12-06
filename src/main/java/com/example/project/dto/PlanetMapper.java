package com.example.project.dto;

import com.example.project.entity.Planet;
import org.springframework.stereotype.Component;

@Component
public class PlanetMapper {
    public PlanetDTO toPlanetDTO(Planet planet) {
        return new PlanetDTO(
                planet.getPlanetId(),
                planet.getPlanetName(),
                planet.getPlanetType(),
                planet.getRadiusKm(),
                planet.getMassKg(),
                planet.getOrbitalPeriodDays()
        );
    }

    public Planet toEntity(PlanetDTO planetDTO) {
        return new Planet(
                planetDTO.getPlanetId(),
                planetDTO.getPlanetName(),
                planetDTO.getPlanetType(),
                planetDTO.getRadiusKm(),
                planetDTO.getMassKg(),
                planetDTO.getOrbitalPeriodDays()
        );
    }
}