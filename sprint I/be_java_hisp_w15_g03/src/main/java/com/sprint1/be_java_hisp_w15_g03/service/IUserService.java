package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;

public interface IUserService {
    void followSeller(Integer userId, Integer sellerToFollow);
    SellerCountDTO getFollowersCount(Integer sellerId);
    SellerFListDTO getFollowersList(Integer sellerId, String order);
    UserListDTO  getFollowedList(Integer userId, String order);
    void unFollowSeller(Integer userId, Integer sellerToUnfollow);
}
