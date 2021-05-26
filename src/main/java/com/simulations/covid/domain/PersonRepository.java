package com.simulations.covid.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface PersonRepository extends JpaRepository<Person,Integer> {

    List<Person> findAllBySimulationId(int id);

}
