package com.example.covid.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SymptomDTO implements Serializable {
    private String name;
    private int severityLevel;
}
