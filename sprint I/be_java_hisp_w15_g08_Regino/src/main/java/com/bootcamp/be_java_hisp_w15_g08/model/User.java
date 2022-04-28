package com.bootcamp.be_java_hisp_w15_g08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userID;
    private String name;
    private List<User> following;// Esta lista guarda los usurios a los que un usuario sigue.
    private List<User> followers;// Esta lista guarda los usuarios que siguen a el usuario creado.
    private Map<Integer, Post> posts;// Lista de publicaciones realizadas.
    private List<PostPromo> postPromos;

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.posts = new HashMap<>();
        this.postPromos = new ArrayList<>();
    }

    public void addFollower(User user){
        followers.add(user);
    }

    public void addFollowed(User user){
        following.add(user);
    }

    public void removeFollower(User user){
        followers.remove(user);
    }

    public void removeFollowed(User user){
        following.remove(user);
    }

    public void addPost(Post post){
        posts.put(post.getPostID(),post);
    }

    public void addPostPromo(PostPromo postPromo){
        postPromos.add(postPromo);
    }


}
