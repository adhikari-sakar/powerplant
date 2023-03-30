package com.proshore.powerplant.domain.model;

import com.proshore.powerplant.application.exception.DataNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@AllArgsConstructor
public class Battery extends BaseModel<Long> {

    private final Name name;
    private final Code postcode;
    private final Capacity capacity;

    @Getter
    public static class Statistics {

        private final List<Name> names;
        private final Capacity totalCapacity;
        private final Capacity averageCapacity;

        public Statistics(List<Battery> batteries) {
            if (batteries == null)
                throw new DataNotFoundException("Data not found");
            this.names = sortedNames(batteries);
            this.totalCapacity = totalCapacity(capacities(batteries));
            this.averageCapacity = averageCapacity(capacities(batteries));
        }

        private List<Name> sortedNames(List<Battery> batteries) {
            List<String> sortedNames = batteries.stream().map(Battery::getName).map(Name::getName).sorted().collect(toList());
            return sortedNames.stream().map(Name::new).collect(toList());
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

}
