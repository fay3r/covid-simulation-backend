package com.simulations.covid.controller;

import com.simulations.covid.domain.SimulatorFacade;
import com.simulations.covid.dto.SimulationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class SimulatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorController.class);

    private final SimulatorFacade simulatorFacade;

    public SimulatorController(SimulatorFacade simulatorFacade) {
        this.simulatorFacade = simulatorFacade;
    }

    @CrossOrigin
    @PutMapping(value = "/covid/simulation", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    ResponseEntity runSimulation(@RequestBody SimulationDto simulationDto){
        LOGGER.info("SIMULATION STARTED");
        return ResponseEntity.ok(simulatorFacade.runSimulation(simulationDto));
    }
}
