package com.example.project.controller;

import com.example.project.dto.PlanetDTO;
import com.example.project.dto.PlanetMapper;
import com.example.project.service.PlanetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planets")
@RequiredArgsConstructor
public class PlanetController {
    private final PlanetService planetService;

    // Add a new planet to the database
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetDTO createPlanet(@Valid @RequestBody PlanetDTO planetDTO) {
        return planetService.addPlanet(planetDTO);
    }

    // Retrieve all planets
    @GetMapping
    public List<PlanetDTO> getAllPlanets() {
        return planetService.getAllPlanets();
    }

    // Retrieve a planet by its unique ID
    @GetMapping("/{id}")
    public PlanetDTO getPlanetById(@PathVariable Long id) {
        return planetService.getPlanetById(id);
    }

    // Update the details of an existing planet (e.g., change its mass)
    @PutMapping("/{id}")
    public PlanetDTO updatePlanet(
            @PathVariable Long id,
            @Valid @RequestBody PlanetDTO planetDTO) {  // Added @Valid
        return planetService.updatePlanet(id, planetDTO);
    }

    // Remove a planet from the database by its unique ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlanet(@PathVariable Long id) {
        planetService.deletePlanet(id);
    }

    // Retrieve planets based on their type (e.g., gas giant, terrestrial)
    @GetMapping("/type/{type}")
    public List<PlanetDTO> getPlanetsByType(@PathVariable String type) {
        return planetService.getPlanetsByType(type.toLowerCase());
    }
}