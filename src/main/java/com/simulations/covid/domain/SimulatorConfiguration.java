package com.simulations.covid.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class SimulatorConfiguration {

    @Bean
    SimulatorFacade simulatorFacade(SimulationRepository simulationRepository,
                                    SimulationDayRepository simulationDayRepository,
                                    PersonRepository personRepository) {
        DataCreator dataCreator = new DataCreator();
        SimulatorService simulatorService = new SimulatorService();
        return new SimulatorFacade(
                simulationDayRepository,
                simulationRepository ,
                personRepository,
                dataCreator,
                simulatorService);
    }
}
