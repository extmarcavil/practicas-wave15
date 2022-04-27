package com.meli.responseentity.persondto.model;

import java.util.Objects;

public class Sport {

    private final String name;
    private final int level;

    public Sport(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return level == sport.level && Objects.equals(name, sport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
