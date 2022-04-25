package com.springp2pg.covid19.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomDTO {


    private String severity_level;


    public SymptomDTO() {
    }

    public SymptomDTO(String severity_level) {

        this.severity_level = severity_level;
    }
}
