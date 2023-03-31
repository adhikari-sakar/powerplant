package com.proshore.powerplant.domain.model;

import com.proshore.powerplant.application.exception.InvalidDataException;
import lombok.Getter;
import lombok.Value;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;

@Value
@Getter
public class Capacity {

    DecimalFormat formatter = new DecimalFormat("0.00");
    Double unit;

    public Capacity format() {
        if (unit == null || unit.isNaN())
            throw new InvalidDataException("Invalid Capacity");
        return new Capacity(parseDouble(formatter.format(unit)));
    }
}
