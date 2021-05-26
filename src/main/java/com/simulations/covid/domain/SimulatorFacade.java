package com.simulations.covid.domain;

import com.simulations.covid.dto.PersonDto;
import com.simulations.covid.dto.SimulationDayDto;
import com.simulations.covid.dto.SimulationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class SimulatorFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorFacade.class);

    private SimulationDayRepository simulationDayRepository;
    private SimulationRepository simulationRepository;
    private PersonRepository personRepository;
    private DataCreator dataCreator;
    private SimulatorService simulatorService;

    public SimulatorFacade(SimulationDayRepository simulationDayRepository,
                           SimulationRepository simulationRepository,
                           PersonRepository personRepository,
                           DataCreator dataCreator,
                           SimulatorService simulatorService) {
        this.simulationDayRepository = simulationDayRepository;
        this.simulationRepository = simulationRepository;
        this.personRepository = personRepository;
        this.dataCreator = dataCreator;
        this.simulatorService = simulatorService;

    }

    public List<SimulationDayDto> runSimulation(SimulationDto simulationDto) {
        int simulationId = dataCreator.putData(simulationDto,simulationRepository,personRepository);
        List<PersonDto> persons = personRepository.findAllBySimulationId(simulationId)
                .stream().map(Person::dto).collect(Collectors.toList());
        simulatorService.simulate(simulationDto,simulationDayRepository,persons);

        return simulationDayRepository.findAllBySimulationId(simulationId)
                .stream().map(SimulationDay::dto).collect(Collectors.toList());

    }
}



/*
*   Stworzenie rekordow w bazie,
*   symulacja 1 dnia,
*   aktualizacja bazy,
*   nowy wpis
*
* */
