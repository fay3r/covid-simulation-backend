package com.simulations.covid.domain;

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
class SimulationDay {

    @Id
    @Column(name = "day_id")
    private Integer id;
    @Column(name = "simulation_id")
    private Integer simulationId;
    @Column(name = "day_number")
    private Integer dayNumber;
    @Column(name = "infected_people")
    private Integer infectedPeople;
    @Column(name = "vulnerable_people")
    private Integer vulnerablePeople;
    @Column(name = "dead_people")
    private Integer deadPeople;
    @Column(name = "healed_people")
    private Integer healedPeople;

    SimulationDayDto dto() {
        return SimulationDayDto.builder()
                .dayNumber(this.dayNumber)
                .infectedPeople(this.infectedPeople)
                .vulnerablePeople(this.vulnerablePeople)
                .deadPeople(this.deadPeople)
                .healedPeople(this.healedPeople)
                .build();
    }
}
