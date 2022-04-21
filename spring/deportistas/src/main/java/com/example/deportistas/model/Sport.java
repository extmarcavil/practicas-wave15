package com.example.deportistas.model;

public class Sport {
    private String id;
    private String name;
    private int lvl;

    public Sport(String id, String name, int lvl) {
        this.id = id;
        this.name = name;
        this.lvl = lvl;
    }

    public Sport(String name, int lvl) {
        this.name = name;
        this.lvl = lvl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }
}
