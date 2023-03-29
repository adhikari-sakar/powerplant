package com.proshore.powerplant.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BatteryRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String postCode;
    @NotNull
    @Min(1)
    private Integer capacity;
}
