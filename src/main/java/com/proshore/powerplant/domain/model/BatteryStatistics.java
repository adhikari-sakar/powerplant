package com.proshore.powerplant.domain.model;

import com.proshore.powerplant.application.exception.DataNotFoundException;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class BatteryStatistics {
    private final List<String> names;
    private final Capacity totalCapacity;
    private final Capacity averageCapacity;

    public BatteryStatistics(List<Battery> batteries) {
        if (batteries == null)
            throw new DataNotFoundException("Data not found");
        this.names = sortedNames(batteries);
        this.totalCapacity = totalCapacity(capacities(batteries));
        this.averageCapacity = averageCapacity(capacities(batteries));
    }

    private List<String> sortedNames(List<Battery> batteries) {
        return batteries.stream().map(Battery::getName).map(Name::getName).sorted().collect(toList());
    }

    private List<Capacity> capacities(List<Battery> batteries) {
        return batteries.stream().map(Battery::getCapacity).collect(toList());
    }

    private Capacity totalCapacity(List<Capacity> capacities) {
        return new Capacity(capacities.stream().mapToDouble(Capacity::getUnit).sum());
    }

    private Capacity averageCapacity(List<Capacity> capacities) {
        return new Capacity(capacities.stream().mapToDouble(Capacity::getUnit).average().orElse(0.0)).format();
    }
}