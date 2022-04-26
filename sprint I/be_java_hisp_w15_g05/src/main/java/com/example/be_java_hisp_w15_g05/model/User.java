package com.example.be_java_hisp_w15_g05.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class User {
    private int userId;
    private String name;
    private boolean isSeller;

    private ArrayList<Integer> seguidos = new ArrayList<>();
    private ArrayList<Integer> seguidores = new ArrayList<>();

    public User(int userId, String name, boolean isSeller) {
        this.userId = userId;
        this.name = name;
        this.isSeller = isSeller;
    }

    public void agregarSeguidor(int id){
        seguidores.add(id);
    }

    public void seguir(int id){
        seguidos.add(id);
    }
}

