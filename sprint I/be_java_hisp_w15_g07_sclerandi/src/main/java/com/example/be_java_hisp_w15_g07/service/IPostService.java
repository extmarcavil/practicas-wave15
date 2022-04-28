package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07.dto.request.NewPromoPostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;

public interface IPostService {

    UserFollowedPostsDTO getFollowedPosts(Integer userId, String order);

    void newPost(NewPostDTO postDTO);

    void newPromoPost(NewPromoPostDTO postDTO);
}
