package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;

public interface IUserService {
    FollowersCountDTO countFollers(Integer idUser);
    FollowersListDTO followersListDTO (Integer idUser);
    void addPost(NewPostDTO newPostDTO);
    void  followUser(Integer idFollowed, Integer idFollower);
    void unFollowUser(Integer idFollowed, Integer idFollower);


}
