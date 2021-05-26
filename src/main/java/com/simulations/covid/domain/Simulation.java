package com.simulations.covid.domain;


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
class Simulation {

    @Id
    @Column(name = "simulation_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private Integer population;
    @Column(name = "infected")
    private Integer infected;
    @Column(name = "r")
    private Integer r;
    @Column(name = "mortality")
    private Integer mortality;
    @Column(name = "recovery_time")
    private Integer recoveryTime;
    @Column(name = "mortality_time")
    private Integer mortalityTime;
    @Column(name = "simulation_time")
    private Integer simulationTime;


}
