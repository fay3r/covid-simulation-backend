package com.simulations.covid.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface SimulationRepository extends JpaRepository<Simulation,Integer> {


}
