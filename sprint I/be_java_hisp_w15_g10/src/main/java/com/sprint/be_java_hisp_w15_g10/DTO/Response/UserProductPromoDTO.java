package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.be_java_hisp_w15_g10.Model.Post;

import java.util.List;

public class UserProductPromoDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private List<Post> posts;

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
