package com.bootcamp.be_java_hisp_w15_g02.model;

import java.util.List;


public class User {

    private int user_id;
    private String user_name;
    private List<Follow> followList;
    private List<Follow> followerList;

    public User() {
    }

    public User(int user_id, String user_name, List<Follow> followList, List<Follow> followerList) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followList = followList;
        this.followerList = followerList;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
}
