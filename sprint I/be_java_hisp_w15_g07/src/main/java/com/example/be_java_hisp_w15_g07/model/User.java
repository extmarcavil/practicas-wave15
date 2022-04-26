package com.example.be_java_hisp_w15_g07.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Setter
@Getter
@ToString
public class User {
    private Integer userId;
    private String userName;
    private Set<Integer> followers;
    private Set<Integer> followed;
    private List<Integer> posts;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new TreeSet<>();
        this.followed = new TreeSet<>();
        this.posts = new ArrayList<>();
    }

    public Boolean addUserToFollow(Integer userId) {
        return this.followed.add(userId);
    }

    public Boolean addFollower(Integer userId){
        return this.followers.add(userId);
    }
}
