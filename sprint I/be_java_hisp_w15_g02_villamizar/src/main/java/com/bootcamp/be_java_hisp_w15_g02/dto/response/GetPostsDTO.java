package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.model.Post;

import java.util.List;

public class GetPostsDTO {
    private int userId;
    private List<PostsBySellersDTO> posts;

    public GetPostsDTO(int userId, List<PostsBySellersDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public GetPostsDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PostsBySellersDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBySellersDTO> posts) {
        this.posts = posts;
    }
}
