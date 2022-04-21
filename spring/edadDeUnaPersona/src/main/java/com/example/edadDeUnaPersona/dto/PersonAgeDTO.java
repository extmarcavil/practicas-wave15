package com.example.edadDeUnaPersona.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonAgeDTO implements Serializable {
    //este DTO es el objeto que va a ser devuelto en la response
   Integer age;

    public PersonAgeDTO(Integer age) {
        this.age = age;
    }
}
