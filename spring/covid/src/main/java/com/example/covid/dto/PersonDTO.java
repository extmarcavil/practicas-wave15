package com.example.covid.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonDTO implements Serializable {
    private String fullName;
    private int age;
    private String symptoms;
}
