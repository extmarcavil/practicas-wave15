package com.example.be_java_hisp_w15_g07.dto.response;

import com.example.be_java_hisp_w15_g07.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserFollowedPostsDTO {
    private Integer userID;
    private List<PostDTO> posts;

    public UserFollowedPostsDTO() {
    }

    public UserFollowedPostsDTO(Integer userID, List<PostDTO> posts) {
        this.userID = userID;
        this.posts = posts;
    }
}
