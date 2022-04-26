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

    private ArrayList<Integer> seguidos;
    private ArrayList<Integer> seguidores;

    public User(int userId, String name, boolean isSeller, ArrayList<Integer> seguidos, ArrayList<Integer> seguidores) {
        this.userId = userId;
        this.name = name;
        this.isSeller = isSeller;
        this.seguidos = seguidos;
        this.seguidores = seguidores;
    }
}

