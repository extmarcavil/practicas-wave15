package com.meli.studenttest.exception;

import com.meli.studenttest.dto.response.ResponseStudentDto;

public class StudentAlreadyExistsException extends RuntimeException {

    public StudentAlreadyExistsException(ResponseStudentDto entity) {
        super(String.format("Student with ID %s already exists.", entity.getId()));
    }
}
