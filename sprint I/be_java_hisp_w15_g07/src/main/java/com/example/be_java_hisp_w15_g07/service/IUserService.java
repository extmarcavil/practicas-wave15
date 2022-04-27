package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;

public interface IUserService {

    FollowedDTO getFollowedList(Integer userId);

    FollowersCountDTO followersCount(Integer idUser);

    void followUser(Integer userId, Integer userToFollowId);

    FollowersDTO getFollowersList(Integer userId);

    FollowersDTO getFollowersList(Integer userId, String order);

    FollowedDTO getFollowedList(Integer userId, String order);
}
