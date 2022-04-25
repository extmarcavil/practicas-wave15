package com.springp2pg.covid19.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiskPersonDTO {

    private String name;
    protected String lastName;

    public RiskPersonDTO(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
