package com.bootcamp.ages.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeDTO {
    private Integer age;
    public AgeDTO(Integer age){
        this.age = age;
    }
}
