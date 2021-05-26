package com.simulations.covid.domain;

import com.simulations.covid.dto.SimulationDto;

class SimulationDataValidator {
    private final int ZERO =0;
    boolean validate(SimulationDto simulationDto){
        if(simulationDto.getSimulationTime()>ZERO &&
                simulationDto.getR()>ZERO &&
                simulationDto.getPopulation()>ZERO &&
                simulationDto.getRecoveryTime()>ZERO &&
                simulationDto.getMortality()>ZERO &&
                simulationDto.getInfected()>ZERO &&
                simulationDto.getName() != null &&
                simulationDto.getMortalityTime()>ZERO) {
            return true;
        } else {
            return false;
        }
    }
}
