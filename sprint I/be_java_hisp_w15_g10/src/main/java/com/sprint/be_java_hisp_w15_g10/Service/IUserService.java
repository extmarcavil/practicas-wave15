package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.FollowUserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UnfollowUserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.Model.User;

public interface IUserService {
    UserDTO convertToDTo(User user);
    UserWithFollowersCountDTO getUsersWithFollowersCount(int userId);
    UnfollowUserDTO unfollowUser(int userId, int userIdToUnfollow);
    FollowUserDTO followUser(int userId, int userIdToUnfollow);

}
