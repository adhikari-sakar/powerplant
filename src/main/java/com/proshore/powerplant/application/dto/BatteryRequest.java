package com.proshore.powerplant.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatteryRequest {
    @NotNull(message = "Battery name should not be null")
    @NotEmpty(message = "Battery name should not be empty")
    private String name;
    @NotNull(message = "Battery postcode should not be null")
    @NotEmpty(message = "Battery postcode should not be empty")
    private String postcode;
    @NotNull(message = "Battery capacity should not be null")
    @Min(value = 1, message = "Capacity value should be greater than zero")
    private Integer capacity;
}
