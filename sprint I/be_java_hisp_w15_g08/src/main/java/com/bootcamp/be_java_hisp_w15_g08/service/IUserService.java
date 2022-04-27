package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;

public interface IUserService {
    FollowersCountDTO countFollers(Integer idUser);
    FollowersListDTO getFollowersList(Integer idUser/*,String order*/);
    NewPostDTO addPost(NewPostDTO newPostDTO);
    void  followUser(Integer idFollowed, Integer idFollower);
    void unFollowUser(Integer idFollowed, Integer idFollower);
    FollowersListDTO getFollowedList(Integer userId/*,String order*/);
    PostListDTO getSellersLastsPosts(Integer userId);
}
