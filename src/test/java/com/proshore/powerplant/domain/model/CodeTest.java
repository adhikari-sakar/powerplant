package com.proshore.powerplant.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CodeTest {

    @Test
    void testEquals() {
        Code postcode1 = new Code("6000");
        Code postcode2 = new Code("6000");
        assertThat(postcode1).isEqualTo(postcode2);
    }

    @Test
    void testHashCode() {
        Code postcode1 = new Code("6000");
        Code postcode2 = new Code("6000");
        assertThat(postcode1.hashCode()).isEqualTo(postcode2.hashCode());
    }
}