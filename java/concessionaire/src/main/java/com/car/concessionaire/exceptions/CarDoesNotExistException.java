package com.car.concessionaire.exceptions;

public class CarDoesNotExistException extends RuntimeException {

    public CarDoesNotExistException(Long id) {
        super(String.format("Car with %s does not exist.", id));
    }
}
