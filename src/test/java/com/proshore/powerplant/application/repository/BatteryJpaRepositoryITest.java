package com.proshore.powerplant.application.repository;

import com.proshore.powerplant.application.entity.BatteryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BatteryJpaRepositoryITest {

    @Autowired
    private BatteryJpaRepository jpaRepository;

    @BeforeEach
    void save() {
        jpaRepository.saveAll(List.of(
                battery("TEST_A", 1000, 1000),
                battery("TEST_B", 2000, 2000),
                battery("TEST_C", 3000, 3000),
                battery("TEST_D", 4000, 4000))
        );
    }

    @Test
    void rangeIsInclusive() {
        var batteries = jpaRepository.findAllByPostcodeBetween(1000, 4000);
        assertFalse(batteries.isEmpty());
        assertEquals(4, batteries.size());
    }

    @Test
    void emptyResultIfNotWithinRange() {
        var batteries = jpaRepository.findAllByPostcodeBetween(5000, 10000);
        assertTrue(batteries.isEmpty());
    }

    private BatteryEntity battery(String name, Integer postcode, Integer capacity) {
        var battery = new BatteryEntity();
        battery.setName(name);
        battery.setPostcode(postcode);
        battery.setCapacity(capacity);
        return battery;
    }


}