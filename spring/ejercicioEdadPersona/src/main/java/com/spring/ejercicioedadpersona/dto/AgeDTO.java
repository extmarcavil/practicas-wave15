package com.spring.ejercicioedadpersona.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AgeDTO implements Serializable {
    int age;

    public AgeDTO(int age) {
        this.age = age;
    }
}
