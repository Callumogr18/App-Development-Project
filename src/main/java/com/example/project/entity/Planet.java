package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Planets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planetId;
    @Column(nullable = false)
    private String planetName;
    private String planetType;
    private double radiumKm;
    private double massKg;
    private int orbitalPeriodDays;
}
