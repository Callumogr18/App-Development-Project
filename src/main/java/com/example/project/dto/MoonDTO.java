package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoonDTO {
    private Long moonId;
    private String name;
    private double diameterKm;
    private int orbitalPeriodDays;
    private Long planetId;
}