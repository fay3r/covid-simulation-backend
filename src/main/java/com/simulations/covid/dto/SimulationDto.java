package com.simulations.covid.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimulationDto {

    private Integer id;
    private String name;
    private Integer population;
    private Integer infected;
    private Integer r;
    private Integer mortality;
    private Integer recoveryTime;
    private Integer simulationTime;
}
