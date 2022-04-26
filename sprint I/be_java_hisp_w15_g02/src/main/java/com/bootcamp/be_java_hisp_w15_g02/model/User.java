package com.bootcamp.be_java_hisp_w15_g02.model;

import java.util.ArrayList;
import java.util.List;


public class User {

    private int userId;
    private String userName;

    private boolean isSeller;
    private List<Follow> followList;
    private List<Follow> followerList;

    public User() {
    }

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followList = new ArrayList<>();
        this.followerList = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Follow> getFollowList() {
        return followList;
    }

    public void setFollowList(List<Follow> followList) {
        this.followList = followList;
    }

    public List<Follow> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<Follow> followerList) {
        this.followerList = followerList;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }
}
