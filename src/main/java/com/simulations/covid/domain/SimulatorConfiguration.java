package com.simulations.covid.domain;

import org.springframework.beans.factory.annotation.Autowired;
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
        SimulationDataValidator simulationDataValidator = new SimulationDataValidator();
        return new SimulatorFacade(
                simulationDayRepository,
                simulationRepository ,
                personRepository,
                dataCreator,
                simulatorService,
                simulationDataValidator);
    }
}
