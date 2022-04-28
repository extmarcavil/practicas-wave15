package com.bootcamp.be_java_hisp_w15_g02_sanchez.service;


import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response.GetFollowersCountDTO;

public interface IUserService {
    void follow(int userId, int userIdToFollow);
    void unFollow(int userId, int userIdToUnFollow);
    GetFollowersCountDTO getFollowersCount(int userId);
    GetFollowersBySellerDTO getFollowersBySeller(int userId, String order);
    GetFollowedByUserDTO getFollowedByUser(int userId, String order);
}


