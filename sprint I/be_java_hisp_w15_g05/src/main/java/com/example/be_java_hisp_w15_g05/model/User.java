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

    private ArrayList<User> seguidos = new ArrayList<>();
    private ArrayList<User> seguidores = new ArrayList<>();

    public User(int userId, String name, boolean isSeller) {
        this.userId = userId;
        this.name = name;
        this.isSeller = isSeller;
    }

<<<<<<< HEAD
    public void agregarSeguidor(User user){
        seguidores.add(user);
    }

    public void seguir(User user){
=======
    public void agregarSeguidor(User user) {
        seguidores.add(user);
    }

    public void seguir(User user) {
>>>>>>> rodrigo_gomez
        seguidos.add(user);
    }
}

