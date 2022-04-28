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
    private int promoPosts;

    private ArrayList<User> seguidos = new ArrayList<>();
    private ArrayList<User> seguidores = new ArrayList<>();

    public User(int userId, String name, boolean isSeller) {
        this.userId = userId;
        this.name = name;
        this.isSeller = isSeller;
        this.promoPosts = 0;
    }

    public void agregarSeguidor(User user) {
        seguidores.add(user);
    }

    public void eliminarSeguidor(User user) {
        seguidores.remove(user);
    }

    public void seguir(User user) {
        seguidos.add(user);
    }

    public void dejarDeSeguir(User user) {
        seguidos.remove(user);
    }

    public void aumentarCantPromoPost() { promoPosts ++; }
}

