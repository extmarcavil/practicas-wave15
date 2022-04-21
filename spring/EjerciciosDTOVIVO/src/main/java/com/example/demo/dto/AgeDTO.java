package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeDTO {
    Integer age;

    public AgeDTO(Integer age) {
        this.age = age;
    }
}
