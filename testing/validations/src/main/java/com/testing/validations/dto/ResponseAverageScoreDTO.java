package com.testing.validations.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseAverageScoreDTO {

    private String studentName;
    private String message;
    private Double averageScore;
    private List<SubjectDTO> subjects;
}
