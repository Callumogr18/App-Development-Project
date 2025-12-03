package com.example.project.service;

import com.example.project.dto.MoonDTO;
import com.example.project.dto.PlanetDTO;
import com.example.project.entity.Moon;
import com.example.project.entity.Planet;
import com.example.project.exceptions.NotFoundException;
import com.example.project.repository.MoonRepository;
import com.example.project.repository.PlanetRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MoonServiceImpl implements MoonService {

    private final MoonRepository moonRepository;
    private final PlanetRepo planetRepository;

    @Override
    public MoonDTO addMoon(MoonDTO moonDTO) {
        // Ensure the planet exists before adding the moon
        Planet planet = planetRepository.findById(moonDTO.getPlanetId())
                .orElseThrow(() -> new NotFoundException("Planet not found with id: " + moonDTO.getPlanetId()));

        Moon moon = convertToEntity(moonDTO, planet);
        Moon savedMoon = moonRepository.save(moon);
        return convertToDTO(savedMoon);
    }

    @Override
    public List<MoonDTO> getAllMoons() {
        return moonRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MoonDTO getMoonById(Long id) {
        Moon moon = moonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Moon not found with id: " + id));
        return convertToDTO(moon);
    }

    @Override
    public void deleteMoon(Long id) {
        if (!moonRepository.existsById(id)) {
            throw new NotFoundException("Moon not found with id: " + id);
        }
        moonRepository.deleteById(id);
    }

    @Override
    public List<MoonDTO> getMoonsByPlanetName(String planetName) {
        return moonRepository.findByPlanetPlanetName(planetName)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long countMoonsByPlanetName(String planetName) {
        return moonRepository.countByPlanetPlanetName(planetName);
    }

    // Helper method to convert Entity to DTO
    private MoonDTO convertToDTO(Moon moon) {
        return new MoonDTO(
                moon.getMoonId(),
                moon.getName(),
                moon.getDiameterKm(),
                moon.getOrbitalPeriodDays(),
                moon.getPlanet().getPlanetId()
        );
    }

    // Helper method to convert DTO to Entity
    private Moon convertToEntity(MoonDTO moonDTO, Planet planet) {
        Moon moon = new Moon();
        moon.setMoonId(moonDTO.getMoonId());
        moon.setName(moonDTO.getName());
        moon.setDiameterKm(moonDTO.getDiameterKm());
        moon.setOrbitalPeriodDays(moonDTO.getOrbitalPeriodDays());
        moon.setPlanet(planet);
        return moon;
    }
}
