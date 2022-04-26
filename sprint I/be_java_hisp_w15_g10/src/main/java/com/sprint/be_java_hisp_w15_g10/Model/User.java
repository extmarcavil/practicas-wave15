package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;

    public User(int user_id, String user_name){
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void seguirUsuario(User user){
        followed.add(user);
    }

    public void agregarSeguidor(User user){
        followers.add(user);
    }
}
