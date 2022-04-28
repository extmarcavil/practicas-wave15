package com.example.be_java_hisp_w15_g07.service;


import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07.dto.request.NewPromoPostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.PromoCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPromoPostsDTO;

public interface IPostService {

    void newPost(NewPostDTO postDTO);

    UserFollowedPostsDTO getFollowedPosts(Integer userId, String order);

    void newPromoPost(NewPromoPostDTO promoPostDTO);

    UserFollowedPromoPostsDTO getFollowedPromoPosts(Integer userId);

    PromoCountDTO getpromoPostCount(Integer idUser);

}
