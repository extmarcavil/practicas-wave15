package com.bootcamp.be_java_hisp_w15_g02.dto.response;

public class GetFollowersCountDTO {
    private int userId;
    private String userName;
    private int followersCount;

    public GetFollowersCountDTO(int userId, String userName, int followersCount) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
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

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }
}
