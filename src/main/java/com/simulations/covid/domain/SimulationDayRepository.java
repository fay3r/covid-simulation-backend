package com.simulations.covid.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface SimulationDayRepository extends JpaRepository<SimulationDay,Integer> {

    List<SimulationDay> findAllBySimulationId(@Param("simulation_id") Integer id);
}
