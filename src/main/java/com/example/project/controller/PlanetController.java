package com.example.project.controller;

import com.example.project.service.PlanetService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.project.dto.PlanetMapper;
import com.example.project.dto.PlanetDTO;
import com.example.project.service.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/planets")
@RequiredArgsConstructor
public class PlanetController {
    private static final Logger logger = LoggerFactory.getLogger(PlanetController.class);
    private final PlanetMapper planetMapper;
    private final PlanetService planetService;

    @GetMapping("/test-log")
    public String testLog() {
        logger.info("✅ Logging works when hitting /test-log");
        return "Check your console!";
    }

    // Add a new planet to the database
    @PostMapping
    public ResponseEntity<PlanetDTO> createPlanet(@RequestBody PlanetDTO planetDTO) {
        PlanetDTO createdPlanet = planetService.addPlanet(planetDTO);
        return new ResponseEntity<>(createdPlanet, HttpStatus.CREATED);
    }

    // Retrieve all planets
    @GetMapping
    public ResponseEntity<List<PlanetDTO>> getAllPlanets() {
        List<PlanetDTO> planets = planetService.getAllPlanets();
        return ResponseEntity.ok(planets);
    }

    // Retrieve a planet by its unique ID
    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> getPlanetById(@PathVariable Long id) {
        PlanetDTO planet = planetService.getPlanetById(id);
        return ResponseEntity.ok(planet);
    }

    // Update the details of an existing planet (e.g., change its mass)
    @PutMapping("/{id}")
    public ResponseEntity<PlanetDTO> updatePlanet(
            @PathVariable Long id,
            @RequestBody PlanetDTO planetDTO) {
        PlanetDTO updatedPlanet = planetService.updatePlanet(id, planetDTO);
        return ResponseEntity.ok(updatedPlanet);
    }

    // Remove a planet from the database by its unique ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable Long id) {
        planetService.deletePlanet(id);
        return ResponseEntity.noContent().build();
    }

    // Retrieve planets based on their type (e.g., gas giant, terrestrial)
    @GetMapping("/type/{type}")
    public ResponseEntity<List<PlanetDTO>> getPlanetsByType(@PathVariable String type) {
        List<PlanetDTO> planets = planetService.getPlanetsByType(type.toLowerCase());
        return ResponseEntity.ok(planets);
    }

}
