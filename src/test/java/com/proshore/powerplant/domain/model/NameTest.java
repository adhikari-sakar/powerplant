package com.proshore.powerplant.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @Test
    void testEquals() {
        Name batteryName1 = new Name("Midland");
        Name batteryName2 = new Name("Midland");
        assertThat(batteryName1).isEqualTo(batteryName2);
    }

    @Test
    void testHashCode() {
        Name batteryName1 = new Name("Midland");
        Name batteryName2 = new Name("Midland");
        assertThat(batteryName1.hashCode()).isEqualTo(batteryName2.hashCode());
    }
}