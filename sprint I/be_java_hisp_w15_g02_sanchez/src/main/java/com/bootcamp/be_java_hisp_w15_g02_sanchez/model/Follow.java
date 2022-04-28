package com.bootcamp.be_java_hisp_w15_g02_sanchez.model;

public class Follow {
    private int userToFollow;


    public Follow(int userToFollow) {
        this.userToFollow = userToFollow;
    }

    public int getUserToFollow() {
        return userToFollow;
    }

    public void setUserToFollow(int userToFollow) {
        this.userToFollow = userToFollow;
    }
}
