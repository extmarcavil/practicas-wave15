package com.example.be_java_hisp_w15_g07_ravelli.service;


import com.example.be_java_hisp_w15_g07_ravelli.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.PromoProductsCountDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.UserPromoPosts;

public interface IPostService {

    void newPost(NewPostDTO postDTO);

    UserFollowedPostsDTO getFollowedPosts(Integer userId, String order);

    PromoProductsCountDTO getPromoProductsCountByUserId(Integer userId);

    UserPromoPosts getPromoPosts(Integer userId);
}
