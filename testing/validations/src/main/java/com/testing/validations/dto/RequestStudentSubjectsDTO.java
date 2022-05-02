package com.testing.validations.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestStudentSubjectsDTO {

    private StudentDTO studentName;
    private List<SubjectDTO> subjects;
}
