package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.UserCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowedUsersDTO;
import com.sprint.be_java_hisp_w15_g10.Model.User;

import java.util.List;

public interface IUserService {
    UserWithFollowersCountDTO getUsersWithFollowersCount(int userId);
    UserWithPromoPostCountDTO getUsersWithPromoPostCount(int userID);
    UnfollowUserDTO unfollowUser(int userId, int userIdToUnfollow);
    FollowUserDTO followUser(int userId, int userIdToUnfollow);
    UserWithFollowedUsersDTO getUsersWithFollowers(int userId, String order);
    FollowersDTO getFollowers(int userId, String order);
    UserCreatedDTO createUser(UserCreateDTO userCreateDTO);
    List<UserDTO> getAll(String order);
}
