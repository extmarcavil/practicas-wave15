package com.dtos.athletes.models;

import java.io.Serializable;

public class Sport implements Serializable {

    private String name;
    private String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
