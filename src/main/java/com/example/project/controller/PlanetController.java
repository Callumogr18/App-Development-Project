package com.example.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.project.dto.MoonMapper;
import com.example.project.dto.PlanetMapper;

@RestController
public class PlanetController {
    private static final Logger logger = LoggerFactory.getLogger(PlanetController.class);
    private MoonMapper moonMapper;
    private PlanetMapper planetMapper;
}
