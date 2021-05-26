package com.simulations.covid.domain;

import com.simulations.covid.dto.PersonDto;
import com.simulations.covid.dto.SimulationDayDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
class Person {

    @Id
    @Column(name="person_id")
    private Integer personId;
    @Column(name="simulation_id")
    private Integer simulationId;
    @Column(name="recovered")
    private Boolean recovered;
    @Column(name="infected")
    private Boolean infected;
    @Column(name="infection_days")
    private Integer infectionDays;
    @Column(name="alive")
    private Boolean alive;
    @Column(name="isolated")
    private Boolean isolated;
    @Column(name="mask_bearer")
    private Boolean maskBearer;

    PersonDto dto() {
        return PersonDto.builder()
                .personId(this.personId)
                .simulationId(this.simulationId)
                .recovered(this.recovered)
                .infected(this.infected)
                .infectionDays(this.infectionDays)
                .alive(this.alive)
                .isolated(this.isolated)
                .maskBearer(this.maskBearer)
                .build();
    }
}
