package com.be.java.hisp.w156.be.java.hisp.w156.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void addNewPost(Post newPost) {
        if (posts == null) {
            setPosts(Stream.of(newPost).collect(Collectors.toList()));
        } else {
            getPosts().add(newPost);
        }
    }
}


