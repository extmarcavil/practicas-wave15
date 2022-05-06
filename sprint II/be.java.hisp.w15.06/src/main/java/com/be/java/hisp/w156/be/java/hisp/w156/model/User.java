package com.be.java.hisp.w156.be.java.hisp.w156.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;
    private String name;
    private List<Post> posts;
    private List<User> followers;
    private List<User> followed;

    public User(Integer id, String name, List<User> followers) {
        this.id = id;
        this.name = name;
        this.followers = followers;
    }
}


