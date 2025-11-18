package com.example.project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class PlanetController {
    private static final Logger logger = LoggerFactory.getLogger(PlanetController.class);

    @GetMapping("/test-log")
    public String testLog() {
        logger.info("✅ Logging works when hitting /test-log");
        return "Check your console!";
    }
}
