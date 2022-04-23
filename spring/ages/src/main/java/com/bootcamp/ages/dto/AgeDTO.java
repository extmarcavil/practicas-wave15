package com.bootcamp.ages.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeDTO {
    private Integer edad;

    public AgeDTO(Integer edad) {
        this.edad = edad;
    }
}
