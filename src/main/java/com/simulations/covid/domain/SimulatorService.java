package com.simulations.covid.domain;

import com.simulations.covid.dto.PersonDto;
import com.simulations.covid.dto.SimulationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

class SimulatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimulatorService.class);
    private final int ZERO = 0;
    private final int ONE = 1;
    private final double NON_CONTAGIOUS_PART_OF_TIME = 0.5;


    public void simulate(SimulationDto simulationDto,
                         SimulationDayRepository simulationDayRepository,
                         List<PersonDto> people) {

        int rRatio = simulationDto.getR();
        int simulationDayId = people.get(ONE).getSimulationId();
        int deadPeople, healedPeople, vulnerablePeople, predictedInfections;
        int dayNextIndex = (int) simulationDayRepository.count();

        for (int index = 1; index <= simulationDto.getSimulationTime(); index++) {

            LOGGER.info("Simulate Day: {}", index);

            int predictedRecoveryTime = simulationDto.getRecoveryTime();
            int predictedNumberOfDeaths = simulationDto.getMortality();

            predictedInfections = (int) people.stream()
                    .filter(personDto -> !personDto.getIsolated())
                    .filter(personDto ->
                            personDto.getInfected() &&
                                    personDto.getInfectionDays() > predictedRecoveryTime * NON_CONTAGIOUS_PART_OF_TIME)
                    .count() * rRatio;
            LOGGER.info("Current R: {}", rRatio);
            LOGGER.info("Predicted Infections {}", predictedInfections);

            for (PersonDto personDto : people) {
                int personIndex = people.indexOf(personDto);
                int days = personDto.getInfectionDays();
                if (predictedNumberOfDeaths > ZERO && personDto.getAlive() && personDto.getInfected()) {
                    if (days == simulationDto.getMortalityTime()) {
                        personDto.setAlive(false);
                        personDto.setInfected(false);
                        predictedNumberOfDeaths--;
                    }
                } else if (predictedInfections > ZERO && !personDto.getInfected()
                        && personDto.getAlive() && !personDto.getRecovered()) {
                    if(!personDto.getMaskBearer() && randomBool()) {
                        personDto.setInfected(true);
                        personDto.setIsolated(randomBool());
                        predictedInfections--;
                    }
                }
                if (personDto.getInfected() && personDto.getAlive()) {
                    if (days > predictedRecoveryTime) {
                        personDto.setInfected(false);
                        personDto.setRecovered(true);
                    } else {
                        personDto.setInfectionDays(days + ONE);
                    }
                }
                people.set(personIndex, personDto);
            }

            predictedInfections = (int) people.stream()
                    .filter(PersonDto::getInfected).count();

            deadPeople = (int) people.stream()
                    .filter(personDto -> !personDto.getAlive()).count();

            healedPeople = (int) people.stream()
                    .filter(PersonDto::getRecovered).count();

            vulnerablePeople = simulationDto.getPopulation() - predictedInfections - deadPeople - healedPeople;

            simulationDayRepository.save(new SimulationDay().toBuilder()
                    .simulationId(simulationDayId)
                    .dayNumber(index)
                    .deadPeople(deadPeople)
                    .healedPeople(healedPeople)
                    .vulnerablePeople(vulnerablePeople)
                    .id(dayNextIndex++)
                    .infectedPeople(predictedInfections)
                    .build());

            rRatio = calculateR(rRatio,deadPeople,predictedInfections,people.size());
            LOGGER.info("END OF THE DAY");

            if (predictedInfections == ZERO && vulnerablePeople == ZERO) {
                LOGGER.info("END OF THE PANDEMY AFTER {} DAY", index);
                break;
            }
        }
    }

    private boolean randomBool(){
        return new Random().nextBoolean();
    }

    private int calculateR(int currentR, int deaths, int infections, int population){
        int newR = (int)(currentR * (Math.random() * 2) + 0.50);
        return (newR == 0 || newR< 0.5*currentR) ? currentR : newR;
    }
}
