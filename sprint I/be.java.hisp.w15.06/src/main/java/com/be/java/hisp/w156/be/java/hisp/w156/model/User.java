package com.be.java.hisp.w156.be.java.hisp.w156.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;
    private String name;
    private List<Post> posts;
    private List<User> followers;
    private List<User> followed;

}
