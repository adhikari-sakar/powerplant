package com.proshore.powerplant.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Battery extends BaseModel<Long> {

    private final Name name;
    private final Code postCode;
    private final Capacity capacity;

}
