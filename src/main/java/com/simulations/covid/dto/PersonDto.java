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
    private Boolean recovered;
    private Boolean infected;
    private Integer infectionDays;
    private Boolean alive;
}
