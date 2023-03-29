
package com.proshore.powerplant.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatteryResponse {
    private List<String> names;
    private Double totalCapacity;
    private Double averageCapacity;
}
