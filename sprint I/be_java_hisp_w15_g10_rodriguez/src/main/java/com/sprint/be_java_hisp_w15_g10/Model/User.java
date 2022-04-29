package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User implements IIdInterface {
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

    public User() {
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void seguirUsuario(User user){ followed.add(user); }

    public void agregarSeguidor(User user){ followers.add(user); }

    public void agregarPost(Post post){ posts.add(post); }

    public void dejarDeSeguir(User user){ followed.remove(user); }

    public void eliminarSeguidor(User user){ followers.remove(user); }

    @Override
    public int getId() {
        return user_id;
    }

    @Override
    public <T> boolean compares(T field) {
        return user_name.equals(field);
    }

    @Override
    public void setId(int id) {
        user_id = id;
    }
}
