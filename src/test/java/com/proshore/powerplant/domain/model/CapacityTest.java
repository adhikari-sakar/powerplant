package com.proshore.powerplant.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CapacityTest {

    @Test
    void format() {
        Capacity capacity = new Capacity(10.123).format();
        assertThat(10.12).isEqualTo(capacity.getUnit());
    }

    @Test
    void testEquals() {
        Capacity capacity1 = new Capacity(10.123);
        Capacity capacity2 = new Capacity(10.123);
        assertThat(capacity1).isEqualTo(capacity2);
    }

    @Test
    void testHashCode() {
        Capacity capacity1 = new Capacity(10.123);
        Capacity capacity2 = new Capacity(10.123);
        assertThat(capacity1.hashCode()).isEqualTo(capacity2.hashCode());
    }
}