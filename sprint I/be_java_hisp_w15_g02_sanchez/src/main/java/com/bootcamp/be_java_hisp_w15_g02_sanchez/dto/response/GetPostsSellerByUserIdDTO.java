package com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response;

import java.util.List;

public class GetPostsSellerByUserIdDTO {
    private int userId;
    private List<PostsBySellersDTO> posts;

    public GetPostsSellerByUserIdDTO(int userId, List<PostsBySellersDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public GetPostsSellerByUserIdDTO() {
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
