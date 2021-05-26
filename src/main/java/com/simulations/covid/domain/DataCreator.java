package com.simulations.covid.domain;

import com.simulations.covid.dto.SimulationDto;

class DataCreator {

    private final int ZERO=0;
    private final int ONE=1;

    public int putData(SimulationDto simulationDto,
                        SimulationRepository simulationRepository,
                        PersonRepository personRepository) {

        int simulationId = (int) simulationRepository.count() + ONE;
        simulationRepository.save(
                new Simulation().toBuilder()
                        .id(simulationId)
                        .name(simulationDto.getName())
                        .population(simulationDto.getPopulation())
                        .infected(simulationDto.getInfected())
                        .r(simulationDto.getR())
                        .mortality(simulationDto.getMortality())
                        .recoveryTime(simulationDto.getRecoveryTime())
                        .mortalityTime(simulationDto.getMortalityTime())
                        .simulationTime(simulationDto.getSimulationTime())
                        .build());
        int count = (int) personRepository.count();
        int numberOfInfected = simulationDto.getInfected();
        boolean isInfected;
        int days;
        for (int index = ONE; index <= simulationDto.getPopulation(); index++) {
            if (numberOfInfected > ZERO) {
                numberOfInfected--;
                isInfected = true;
                days = (int) (Math.floor(Math.random() * 6) + 1);;
            } else {
                isInfected =false;
                days=ZERO;
            }

            personRepository.save(
                    new Person().toBuilder()
                            .personId(count + index)
                            .simulationId(simulationId)
                            .recovered(false)
                            .infected(isInfected)
                            .infectionDays(days)
                            .alive(true)
                            .maskBearer(false)
                            .isolated(false)
                            .build());
        }
        return simulationId;
    }
}
