package com.car.concessionaire.exceptions;

import com.car.concessionaire.model.Car;

public class CarAlreadyExistsException extends RuntimeException {

    public CarAlreadyExistsException(Car car) {
        super(String.format("%s already exists.", car));
    }
}
