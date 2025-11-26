package com.example.project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoonDTO {
    private Long moonId;

    @NotBlank(message = "Moon name must not be blank")
    private String name;

    @Min(value = 0, message = "Diameter must be a a positive value")
    private double diameterKm;

    @Min(value = 0, message = "Orbital period must be a a positive value")
    private int orbitalPeriodDays;

    @NotNull(message = "PlanetID is required")
    @Min(value = 1, message = "PlanetID must be at least 1")
    private Long planetId;
}