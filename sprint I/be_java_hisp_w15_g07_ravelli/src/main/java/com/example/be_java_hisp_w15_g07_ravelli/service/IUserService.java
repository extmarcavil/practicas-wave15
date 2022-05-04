package com.example.be_java_hisp_w15_g07_ravelli.service;

import com.example.be_java_hisp_w15_g07_ravelli.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07_ravelli.dto.response.FollowersCountDTO;

public interface IUserService {

    FollowedDTO getFollowedList(Integer userId);

    FollowersCountDTO followersCount(Integer idUser);

    void followUser(Integer userId, Integer userToFollowId);

    void unfollowUser(Integer userId, Integer userToUnfollowId);

    FollowersDTO getFollowersList(Integer userId);

    FollowersDTO getFollowersList(Integer userId, String order);

    FollowedDTO getFollowedList(Integer userId, String order);
}
