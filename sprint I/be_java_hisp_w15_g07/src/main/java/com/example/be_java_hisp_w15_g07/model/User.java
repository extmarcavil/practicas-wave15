package com.example.be_java_hisp_w15_g07.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {
    private Integer userId;
    private String userName;
    private List<Integer> followers;
    private List<Integer> followed;
    private List<Integer> posts;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }
}
