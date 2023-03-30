package com.proshore.powerplant.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@JsonFormat
public class BatteryRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    private String postcode;
    @NotNull
    @Min(1)
    private Integer capacity;
}
