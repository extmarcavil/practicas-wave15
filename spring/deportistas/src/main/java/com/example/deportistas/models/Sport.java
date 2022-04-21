package com.example.deportistas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sport {
    private String name;
    private String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
