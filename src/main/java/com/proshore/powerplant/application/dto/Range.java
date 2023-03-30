package com.proshore.powerplant.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Range {
    @NotNull
    @NotEmpty
    private String from;
    @NotNull
    @NotEmpty
    private String to;
}
