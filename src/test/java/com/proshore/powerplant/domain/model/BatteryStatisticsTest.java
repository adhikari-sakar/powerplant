package com.proshore.powerplant.domain.model;

import com.proshore.powerplant.application.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BatteryStatisticsTest {

    private final Battery.Statistics statistics = new Battery.Statistics(List.of(
            battery(new Name("D_TEST"), new Code("1000"), new Capacity(4000.0)),
            battery(new Name("A_TEST"), new Code("1000"), new Capacity(1000.0)),
            battery(new Name("C_TEST"), new Code("1000"), new Capacity(3000.0)),
            battery(new Name("B_TEST"), new Code("1000"), new Capacity(2000.0))
    ));


    @Test
    void exceptionIfBatteriesAreNotSupplied() {
        assertThrows(DataNotFoundException.class, () -> new Battery.Statistics(null));
        assertThrows(DataNotFoundException.class, () -> new Battery.Statistics(List.of()));
    }

    @Test
    void namesAreSorted() {
        var names = statistics.getNames();
        assertFalse(names.isEmpty());
        assertEquals(4, names.size());
        assertEquals(new Name("A_TEST"), names.get(0));
        assertEquals(new Name("B_TEST"), names.get(1));
        assertEquals(new Name("C_TEST"), names.get(2));
        assertEquals(new Name("D_TEST"), names.get(3));
    }

    @Test
    void totalCapacityIsSummed() {
        assertEquals(10000.0, statistics.getTotalCapacity().getUnit());
    }

    @Test
    void averageCapacityIsCalculated() {
        assertEquals(2500.0, statistics.getAverageCapacity().getUnit());
    }

    private Battery battery(Name name, Code code, Capacity capacity) {
        return new Battery(name, code, capacity);
    }
}