package com.simulations.covid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Person {

    @Id
    @Column(name="person_id")
    private Integer personId;
    @Column(name="simulation_id")
    private Integer simulationId;
    @Column(name="recovered")
    private Integer recovered;
    @Column(name="infected")
    private Integer infected;
    @Column(name="infection_days")
    private Integer infectionDays;
}
