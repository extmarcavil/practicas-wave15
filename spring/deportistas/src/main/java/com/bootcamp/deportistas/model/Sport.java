package com.bootcamp.deportistas.model;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class Sport {

    String name;
    String level;

    public Sport() {
    }

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }
}


