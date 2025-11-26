package com.example.project.service;

import com.example.project.dto.PlanetDTO;
import com.example.project.entity.Planet;
import com.example.project.exceptions.NotFoundException;
import com.example.project.repository.PlanetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {
    private final PlanetRepo planetRepository;

    @Override
    public PlanetDTO addPlanet(PlanetDTO planetDTO) {
        Planet planet = convertToEntity(planetDTO);
        Planet savedPlanet = planetRepository.save(planet);
        return convertToDTO(savedPlanet);
    }

    @Override
    public List<PlanetDTO> getAllPlanets() {
        return planetRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanetDTO getPlanetById(Long id) {
        Planet planet = planetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Planet not found with id: " + id));
        return convertToDTO(planet);
    }

    @Override
    public PlanetDTO updatePlanet(Long id, PlanetDTO planetDTO) {
        Planet existingPlanet = planetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Planet not found with id: " + id));

        // Update fields
        existingPlanet.setPlanetName(planetDTO.getPlanetName());
        existingPlanet.setPlanetType(planetDTO.getPlanetType());
        existingPlanet.setRadiusKm(planetDTO.getRadiusKm());
        existingPlanet.setMassKg(planetDTO.getMassKg());
        existingPlanet.setOrbitalPeriodDays(planetDTO.getOrbitalPeriodDays());

        Planet updatedPlanet = planetRepository.save(existingPlanet);
        return convertToDTO(updatedPlanet);
    }

    @Override
    public void deletePlanet(Long id) {
        if (!planetRepository.existsById(id)) {
            throw new NotFoundException("Planet not found with id: " + id);
        }
        planetRepository.deleteById(id);
    }

    @Override
    public List<PlanetDTO> getPlanetsByType(String type) {
        return planetRepository.findByPlanetType(type)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to convert Entity to DTO
    private PlanetDTO convertToDTO(Planet planet) {
        return new PlanetDTO(
                planet.getPlanetId(),
                planet.getPlanetName(),
                planet.getPlanetType(),
                planet.getRadiusKm(),
                planet.getMassKg(),
                planet.getOrbitalPeriodDays()
        );
    }

    // Helper method to convert DTO to Entity
    private Planet convertToEntity(PlanetDTO planetDTO) {
        return new Planet(
                planetDTO.getPlanetId(),
                planetDTO.getPlanetName(),
                planetDTO.getPlanetType(),
                planetDTO.getRadiusKm(),
                planetDTO.getMassKg(),
                planetDTO.getOrbitalPeriodDays()
        );
    }
}
