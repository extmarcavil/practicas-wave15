package com.bootcamp.be_java_hisp_w15_g02.service;


import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;

public interface IUserService {
    void follow(int userId, int userIdToFollow);
    void unFollow(int userId, int userIdToUnFollow);
    GetFollowersCountDTO getFollowersCount(int userId);
    GetFollowersBySellerDTO getFollowersBySeller(int userId, String order);
    GetFollowedByUserDTO getFollowedByUser(int userId, String order);
}


