package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.*;

public interface IUserService {
    FollowersCountDTO countFollers(Integer idUser);
    FollowersListDTO getFollowersList(Integer idUser,String order);
    PostNotUserIdDTO addPost(NewPostDTO newPostDTO);
    void  followUser(Integer idFollowed, Integer idFollower);
    void unFollowUser(Integer idFollowed, Integer idFollower);
    FollowersListDTO getFollowedList(Integer userId,String order);
    PostListDTO getSellersLastsPosts(Integer userId, String order);

    void createPromoPost(PromoPostDTO promoPostDTO);

    CountPromoPostDTO countPromoPost(Integer idUser);

    PromoListDTO getPromoList(Integer user_id);
}
