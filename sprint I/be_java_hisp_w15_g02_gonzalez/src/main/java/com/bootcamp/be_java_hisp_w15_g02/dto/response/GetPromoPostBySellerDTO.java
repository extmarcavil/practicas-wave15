package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetPromoPostBySellerDTO {
    private int userId;
    private String userName;
    private List<Post> posts;

    public GetPromoPostBySellerDTO(int userId, String userName, List<Post> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public GetPromoPostBySellerDTO() {
    }
}
