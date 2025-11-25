package com.example.project.controller;

import com.example.project.dto.MoonDTO;
import com.example.project.service.MoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moons")
@RequiredArgsConstructor
public class MoonController {

    private final MoonService moonService;

    // Add a new moon to the database, ensuring the planet exists
    @PostMapping
    public ResponseEntity<MoonDTO> createMoon(@RequestBody MoonDTO moonDTO) {
        MoonDTO createdMoon = moonService.addMoon(moonDTO);
        return new ResponseEntity<>(createdMoon, HttpStatus.CREATED);
    }

    // Retrieve a list of all moons
    @GetMapping
    public ResponseEntity<List<MoonDTO>> getAllMoons() {
        List<MoonDTO> moons = moonService.getAllMoons();
        return ResponseEntity.ok(moons);
    }

    // Retrieve a moon by its unique ID
    @GetMapping("/{id}")
    public ResponseEntity<MoonDTO> getMoonById(@PathVariable Long id) {
        MoonDTO moon = moonService.getMoonById(id);
        return ResponseEntity.ok(moon);
    }

    // Remove a moon from the database by its unique ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoon(@PathVariable Long id) {
        moonService.deleteMoon(id);
        return ResponseEntity.noContent().build();
    }

    // List moons by planet name (retrieve all moons for a specific planet)
    @GetMapping("/planet/{planetName}")
    public ResponseEntity<List<MoonDTO>> getMoonsByPlanetName(@PathVariable String planetName) {
        List<MoonDTO> moons = moonService.getMoonsByPlanetName(planetName);
        return ResponseEntity.ok(moons);
    }

    // Count the number of moons for a specific planet
    @GetMapping("/planet/{planetName}/count")
    public ResponseEntity<Long> countMoonsByPlanetName(@PathVariable String planetName) {
        long count = moonService.countMoonsByPlanetName(planetName);
        return ResponseEntity.ok(count);
    }
}