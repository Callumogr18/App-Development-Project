package com.example.project.service;

import com.example.project.dto.MoonDTO;
import com.example.project.dto.MoonMapper;
import com.example.project.entity.Moon;
import com.example.project.entity.Planet;
import com.example.project.exceptions.NotFoundException;
import com.example.project.repository.MoonRepository;
import com.example.project.repository.PlanetRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MoonServiceImpl implements MoonService {

    private final MoonRepository moonRepository;
    private final PlanetRepo planetRepository;
    private final MoonMapper moonMapper;

    @Override
    public MoonDTO addMoon(MoonDTO moonDTO) {
        Planet planet = planetRepository.findById(moonDTO.getPlanetId())
                .orElseThrow(() -> new NotFoundException("Planet not found with id: " + moonDTO.getPlanetId()));

        Moon moon = moonMapper.toEntity(moonDTO, planet);
        Moon savedMoon = moonRepository.save(moon);
        return moonMapper.toMoonDTO(savedMoon);
    }

    @Override
    public List<MoonDTO> getAllMoons() {
        return moonRepository.findAll()
                .stream()
                .map(moonMapper::toMoonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MoonDTO getMoonById(Long id) {
        Moon moon = moonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Moon not found with id: " + id));
        return moonMapper.toMoonDTO(moon);
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
        return moonRepository.findByPlanetName(planetName)
                .stream()
                .map(moonMapper::toMoonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long countMoonsByPlanetName(String planetName) {
        return moonRepository.countByPlanetName(planetName);
    }
}