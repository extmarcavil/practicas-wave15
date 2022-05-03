package com.meli.studenttest.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super(String.format("Student with ID %s wasn't found", id));
    }
}
