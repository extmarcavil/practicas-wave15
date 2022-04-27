package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.VendedorsFollowedDTO;

public interface IUserService {
    UserWithFollowersCountDTO getUsersWithFollowersCount(int userId);
    UnfollowUserDTO unfollowUser(int userId, int userIdToUnfollow);
    FollowUserDTO followUser(int userId, int userIdToUnfollow);
    VendedorsFollowedDTO getVendorsFollow(int userId, String order);
    FollowersDTO getFollowers(int userId, String order);
}
