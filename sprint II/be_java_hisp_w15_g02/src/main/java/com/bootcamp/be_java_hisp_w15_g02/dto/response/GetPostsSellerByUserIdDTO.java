package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import lombok.Data;

import java.util.List;

@Data
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
