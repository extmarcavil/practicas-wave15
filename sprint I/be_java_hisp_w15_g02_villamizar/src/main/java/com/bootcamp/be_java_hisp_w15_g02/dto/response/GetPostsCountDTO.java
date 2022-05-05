package com.bootcamp.be_java_hisp_w15_g02.dto.response;

public class GetPostsCountDTO {
    private int userId;
    private String userName;
    private int postsCount;

    public GetPostsCountDTO(int userId, String userName, int postsCount) {
        this.userId = userId;
        this.userName = userName;
        this.postsCount = postsCount;
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

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int followersCount) {
        this.postsCount = postsCount;
    }
}
