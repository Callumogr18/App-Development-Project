package com.example.project.controller;

import com.example.project.dto.MoonDTO;
import com.example.project.service.MoonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moons")
@RequiredArgsConstructor
public class MoonController {

    private final MoonService moonService;

    // Add a new moon to the database, ensuring the planet exists
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('STAFF','ADMIN')")
    public MoonDTO createMoon(@Valid @RequestBody MoonDTO moonDTO) {
        return moonService.addMoon(moonDTO);
    }

    // Retrieve a list of all moons
    @GetMapping
    @PreAuthorize("hasAnyRole('STAFF','ADMIN', 'STUDENT')")
    public List<MoonDTO> getAllMoons() {
        return moonService.getAllMoons();
    }

    // Retrieve a moon by its unique ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('STAFF','ADMIN', 'STUDENT')")
    public MoonDTO getMoonById(@PathVariable Long id) {
        return moonService.getMoonById(id);
    }

    // Remove a moon from the database by its unique ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('STAFF','ADMIN')")
    public void deleteMoon(@PathVariable Long id) {
        moonService.deleteMoon(id);
    }

    // List moons by planet name (retrieve all moons for a specific planet)
    @GetMapping("/planet/{planetName}")
    @PreAuthorize("hasAnyRole('STAFF','ADMIN', 'STUDENT')")
    public List<MoonDTO> getMoonsByPlanetName(@PathVariable String planetName) {
        return moonService.getMoonsByPlanetName(planetName);
    }

    // Count the number of moons for a specific planet
    @GetMapping("/planet/{planetName}/count")
    @PreAuthorize("hasAnyRole('STAFF','ADMIN', 'STUDENT')")
    public Long countMoonsByPlanetName(@PathVariable String planetName) {
        return moonService.countMoonsByPlanetName(planetName);
    }
}