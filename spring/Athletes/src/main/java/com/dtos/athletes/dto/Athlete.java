package com.dtos.athletes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Athlete {

    private String personName;
    private String personLastname;
    private String sport;

    public Athlete(String personName, String personLastname, String sport) {
        this.personName = personName;
        this.personLastname = personLastname;
        this.sport = sport;
    }
}
