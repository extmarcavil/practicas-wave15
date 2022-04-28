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

    public void addFollower(User user) {
        seguidores.add(user);
    }

    public void deleteFollower(User user) {
        seguidores.remove(user);
    }

    public void follow(User user) {
        seguidos.add(user);
    }

    public void unfollow(User user) {
        seguidos.remove(user);
    }
}

