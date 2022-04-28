package com.example.be_java_hisp_w15_g07.dto.response;

import com.example.be_java_hisp_w15_g07.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserFollowedPromoPostsDTO {
    public Integer userID;
    public List<PromoPostDTO> posts;

    public UserFollowedPromoPostsDTO() {
    }

    public UserFollowedPromoPostsDTO(Integer userID, List<PromoPostDTO> posts) {
        this.userID = userID;
        this.posts = posts;
    }
}
