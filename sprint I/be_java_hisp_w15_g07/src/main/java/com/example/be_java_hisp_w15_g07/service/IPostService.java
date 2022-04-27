package com.example.be_java_hisp_w15_g07.service;


import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;

public interface IPostService {

    void newPost(NewPostDTO postDTO);

    UserFollowedPostsDTO getFollowedPosts(Integer userId, String order);

}
