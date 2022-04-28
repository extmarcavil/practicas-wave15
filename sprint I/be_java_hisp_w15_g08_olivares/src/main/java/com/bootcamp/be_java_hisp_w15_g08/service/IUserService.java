package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.PromoDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.*;

public interface IUserService {
    FollowersCountDTO countFollers(Integer idUser);
    FollowersListDTO getFollowersList(Integer idUser,String order);
    PostNotUserIdDTO addPost(NewPostDTO newPostDTO);
    void  followUser(Integer idFollowed, Integer idFollower);
    void unFollowUser(Integer idFollowed, Integer idFollower);
    FollowersListDTO getFollowedList(Integer userId,String order);
    PostListDTO getSellersLastsPosts(Integer userId, String order);
    void addPromo(PromoDTO promoDTO);
    PromoCountDTO getPromoCount(Integer userId);
    PromoListDTO getPromoList(Integer userId);

}
