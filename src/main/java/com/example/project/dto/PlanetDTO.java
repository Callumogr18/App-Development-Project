package com.example.project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDTO {
    private Long planetId;

    @NotBlank(message = "Planet name is required")
    private String planetName;

    @NotBlank(message = "Planet type is required")
    @Pattern(regexp = "gas giant|terrestrial|ice giant|dwarf planet",
            message = "Planet type must be one of: gas giant, terrestrial, ice giant, dwarf planet")
    private String planetType;

    @Min(value = 0, message = "Radius of planet must be a positive value")
    private double radiusKm;

    @Min(value = 0, message = "Mass must be a positive value")
    private double massKg;

    @Min(value = 0, message = "Orbital period must be a positive value")
    private int orbitalPeriodDays;
}