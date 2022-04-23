package com.bootcamp.Covid19.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomDTO {

    private int symptom_code;
    private String name;
    private String severity;

}
