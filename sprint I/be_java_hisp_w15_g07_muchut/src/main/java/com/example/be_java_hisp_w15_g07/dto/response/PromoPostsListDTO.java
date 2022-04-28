package com.example.be_java_hisp_w15_g07.dto.response;

import com.example.be_java_hisp_w15_g07.dto.request.ProductDTO;
import com.example.be_java_hisp_w15_g07.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PromoPostsListDTO {
    private Integer userId;
    private String userName;
    private List<Post> posts;

    public PromoPostsListDTO(Integer userId, String userName, List<Post> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }
}
