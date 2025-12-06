package com.example.project.service;

import com.example.project.dto.PlanetDTO;
import com.example.project.dto.PlanetMapper;
import com.example.project.entity.Planet;
import com.example.project.exceptions.NotFoundException;
import com.example.project.repository.PlanetRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlanetServiceImpl implements PlanetService {
    private final PlanetRepo planetRepository;
    private final PlanetMapper planetMapper;

    @Override
    public PlanetDTO addPlanet(PlanetDTO planetDTO) {
        Planet planet = planetMapper.toEntity(planetDTO);
        Planet savedPlanet = planetRepository.save(planet);
        return planetMapper.toPlanetDTO(savedPlanet);
    }

    @Override
    public List<PlanetDTO> getAllPlanets() {
        return planetRepository.findAll()
                .stream()
                .map(planetMapper::toPlanetDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanetDTO getPlanetById(Long id) {
        Planet planet = planetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Planet not found with id: " + id));
        return planetMapper.toPlanetDTO(planet);
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
        return planetMapper.toPlanetDTO(updatedPlanet);
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
                .map(planetMapper::toPlanetDTO)
                .collect(Collectors.toList());
    }
}