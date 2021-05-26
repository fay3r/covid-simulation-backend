package com.simulations.covid.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDto {

    private Integer personId;
    private Integer simulationId;
    private Integer recovered;
    private Integer infected;
    private Integer infectionDays;
}
