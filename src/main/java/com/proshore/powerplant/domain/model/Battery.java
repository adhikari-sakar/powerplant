package com.proshore.powerplant.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Battery extends BaseModel<Long> {

    private final Name name;
    private final Code postcode;
    private final Capacity capacity;

}
