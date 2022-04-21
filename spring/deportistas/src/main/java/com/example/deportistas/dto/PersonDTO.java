package com.example.deportistas.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonDTO implements Serializable{
    private String personFullName;
    private String sportName;
}
