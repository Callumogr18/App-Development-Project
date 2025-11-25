package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Moons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long moonId;
    @Column(nullable = false)
    private String name;
    private double diameterKm;
    private int orbitalPeriodDays;

    @ManyToOne
    @JoinColumn(name="planet_id", nullable = false)
    private Planet planet;
}
