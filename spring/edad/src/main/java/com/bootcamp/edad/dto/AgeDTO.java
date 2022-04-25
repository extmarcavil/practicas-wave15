package com.bootcamp.edad.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AgeDTO implements Serializable {
    Integer age;

    public AgeDTO ( Integer age ) {
        this.age = age;
    }
}
