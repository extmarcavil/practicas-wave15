package com.example.edadpersonaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeDTO {
    private Integer age;

    public AgeDTO(int age) {
        this.age = age;
    }
}
