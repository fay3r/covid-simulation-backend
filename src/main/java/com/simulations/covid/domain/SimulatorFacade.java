package com.simulations.covid.domain;

import com.simulations.covid.dto.PersonDto;
import com.simulations.covid.dto.SimulationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
public class SimulatorFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorFacade.class);

    private final SimulationDayRepository simulationDayRepository;
    private final SimulationRepository simulationRepository;
    private final PersonRepository personRepository;
    private final DataCreator dataCreator;
    private final SimulatorService simulatorService;
    private final SimulationDataValidator simulationDataValidator;

    public SimulatorFacade(SimulationDayRepository simulationDayRepository,
                           SimulationRepository simulationRepository,
                           PersonRepository personRepository,
                           DataCreator dataCreator,
                           SimulatorService simulatorService,
                           SimulationDataValidator simulationDataValidator) {
        this.simulationDayRepository = simulationDayRepository;
        this.simulationRepository = simulationRepository;
        this.personRepository = personRepository;
        this.dataCreator = dataCreator;
        this.simulatorService = simulatorService;
        this.simulationDataValidator = simulationDataValidator;
    }

    public LinkedHashMap<String,Object> runSimulation(SimulationDto simulationDto) {
        LinkedHashMap<String,Object> returnData = new LinkedHashMap<>();
        if(!simulationDataValidator.validate(simulationDto)){
            LOGGER.info("INPUT DATA ERROR");
            returnData.put("error","invalid input");
            return returnData;
        }
        LOGGER.info("CORRECT INPUT DATA");

        LOGGER.info("CREATING THE NECESSARY DATA");
        int simulationId = dataCreator.putData(simulationDto,simulationRepository,personRepository);

        LOGGER.info("COLLECTING INFO ABOUT PEOPLE");
        List<PersonDto> persons = personRepository.findAllBySimulationId(simulationId)
                .stream().map(Person::dto).collect(Collectors.toList());

        LOGGER.info("SIMULATING PANDEMIC RUN");
        simulatorService.simulate(simulationDto,simulationDayRepository,persons);

        returnData.put("simulationDetails",simulationDto);
        returnData.put("simulationId",simulationId);
        returnData.put("run", simulationDayRepository.findAllBySimulationId(simulationId)
                .stream().map(SimulationDay::dto).collect(Collectors.toList()));

        return returnData;

    }
}

