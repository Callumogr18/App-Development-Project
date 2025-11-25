package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDTO {
    private Long planetId;
    private String planetName;
    private String planetType;
    private double radiusKm;
    private double massKg;
    private int orbitalPeriodDays;
}