package com.simulations.covid.domain;

import com.simulations.covid.dto.PersonDto;
import com.simulations.covid.dto.SimulationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SimulatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorService.class);


    public void simulate(SimulationDto simulationDto,
                         SimulationDayRepository simulationDayRepository,
                         List<PersonDto> people) {
        int simulationDayId = people.get(1).getSimulationId();
        for(int index =1; index <= simulationDto.getSimulationTime(); index++){
            LOGGER.info("Simulate Day: {}",index);
            int deadPeople=0,healedPeople=0,vulnerablePeople=0,infectedPeople=0;

            simulationDayRepository.save(new SimulationDay().toBuilder()
                    .simulationId(1)
                    .dayNumber(index)
                    .deadPeople(deadPeople)
                    .healedPeople(healedPeople)
                    .vulnerablePeople(vulnerablePeople)
                    .id(simulationDayId++)
                    .infectedPeople(infectedPeople)
                    .build());
            LOGGER.info("END OF THE DAY");
        }
    }
}
