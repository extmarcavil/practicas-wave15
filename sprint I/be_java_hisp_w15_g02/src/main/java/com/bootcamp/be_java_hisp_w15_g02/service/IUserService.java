package com.bootcamp.be_java_hisp_w15_g02.service;


import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;

public interface IUserService {
    GetFollowersCountDTO getFollowersCount(int userId);
    GetFollowersBySellerDTO getFollowersBySeller(int userId);

    }


