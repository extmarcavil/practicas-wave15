package com.bootcamp.be_java_hisp_w15_g02_sanchez.model;

import java.util.List;

/**
 * This is the model class of a user
 */
public class User {

    private int userId;
    private String userName;

    private List<Follow> followList;
    private List<Follow> followerList;
    private boolean isSeller;

    /**
     * This is the constructor of the user model
     * @param userId Id of the user
     * @param userName Name of the user
     * @param followList List of the users the given user follows
     * @param followerList List of the user's followers
     */
    public User(int userId, String userName, List<Follow> followList, List<Follow> followerList) {
        this.userId = userId;
        this.userName = userName;
        this.followList = followList;
        this.followerList = followerList;
        this.isSeller = false;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", followList=" + followList +
                ", isSeller=" + isSeller +
                '}';
    }
}
