package com.meli.elasticsearch.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

    public EmployeeAlreadyExistsException(String id) {
        super(String.format("Employee with ID %s already exists.", id));
    }
}
