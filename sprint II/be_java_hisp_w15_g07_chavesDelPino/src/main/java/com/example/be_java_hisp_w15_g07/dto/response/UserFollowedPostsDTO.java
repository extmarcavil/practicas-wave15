package com.example.be_java_hisp_w15_g07.dto.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
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
