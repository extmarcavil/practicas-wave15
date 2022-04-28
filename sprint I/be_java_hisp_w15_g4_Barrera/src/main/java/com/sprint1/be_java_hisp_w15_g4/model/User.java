package com.sprint1.be_java_hisp_w15_g4.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class User {
    private int user_id;
    private String user_name;
    private List<User> followers;
    private List<User> following;
    private List<Post> posts;

    public User(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void addFollowing(User user) {
        following.add(user);
    }

    public void removeFollowing(User user) {
        following.remove(user);
    }
    public void removeFollower(User user) {
        followers.remove(user);
    }
    public void addPost(Post post) {
        posts.add(post);
    }

    public int contarProductosDescontados(){
        int count = 0;
        for(Post p: posts){
            if (p.isHas_promo()){
                count++;
            }
        }
        return count;
    }

}
