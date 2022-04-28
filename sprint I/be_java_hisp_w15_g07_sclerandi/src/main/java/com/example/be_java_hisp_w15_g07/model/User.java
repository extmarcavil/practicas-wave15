package com.example.be_java_hisp_w15_g07.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class User implements Comparable<User>{
    private Integer userId;
    private String userName;
    private Set<User> followers;
    private Set<User> followed;
    private List<Post> posts;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new TreeSet<>();
        this.followed = new TreeSet<>();
        this.posts = new ArrayList<>();
    }

    /**
     * add user to follow
     *
     * @param user {@link User)
     * @return {@link Boolean}
     * @see Boolean
     */
    public Boolean addUserToFollow(User user) {
        return this.followed.add(user);
    }

    /**
     * add follower
     *
     * @param user {@link User)
     * @return {@link Boolean}
     * @see Boolean
     */
    public Boolean addFollower(User user){
        return this.followers.add(user);
    }

    /**
     * add new post
     *
     * @param post {@link Post)
     */
    public void newPost(Post post){
        post.setPostId(this.posts.size()+1);
        this.posts.add(post);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.getUserId());
    }

    @Override
    public int compareTo(User user) {
        return this.getUserId().compareTo(user.getUserId());
    }

    @Override
    public String toString() {
        return this.getUserName();
    }
}
