package com.Spring.CalcAge.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AgeDTO implements Serializable {
    private Integer age;

    public AgeDTO(Integer age) {
        this.age = age;
    }
}
