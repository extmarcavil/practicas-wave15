package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.dto.FollowersCountDTO;

public interface IUserService {

    FollowersCountDTO followersCount(Integer idUser);

    void followUser(Integer userId, Integer userToFollowId);

}
