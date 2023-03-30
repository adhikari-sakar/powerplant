package com.proshore.powerplant.application.exception;

public abstract class BatteryException extends RuntimeException {

    public BatteryException(String message) {
        super(message);
    }

}
