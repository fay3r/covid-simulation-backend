package com.simulations.covid.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimulationDayDto {

    private Integer id;
    private Integer simulationId;
    private Integer dayNumber;
    private Integer infectedPeople;
    private Integer vulnerablePeople;
    private Integer deadPeople;
    private Integer healedPeople;
}
