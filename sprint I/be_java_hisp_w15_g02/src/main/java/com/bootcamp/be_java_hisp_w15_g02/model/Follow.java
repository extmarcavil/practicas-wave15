package com.bootcamp.be_java_hisp_w15_g02.model;

public class Follow {
    private int user_to_follow;

    public Follow() {
    }

    public Follow(int user_to_follow) {
        this.user_to_follow = user_to_follow;
    }

    public int getUser_to_follow() {
        return user_to_follow;
    }

    public void setUser_to_follow(int user_to_follow) {
        this.user_to_follow = user_to_follow;
    }
}
