package com.bootcamp.deportes.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sport {
    private String name;
    private String nivel;

    public Sport() {
    }

    public Sport(String name, String nivel) {
        this.name = name;
        this.nivel = nivel;
    }

}
