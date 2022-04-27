package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.UnfollowUserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.VendedorsFollowedDTO;
import com.sprint.be_java_hisp_w15_g10.Model.User;

import java.util.List;

public interface IUserService {
    UserDTO convertToDTo(User user);
    UserWithFollowersCountDTO getUsersWithFollowersCount(int userId);
    UnfollowUserDTO unfollowUser(int userId, int userIdToUnfollow);
    public boolean seguirUsuario(Integer userId, Integer userIdToFollow);
    VendedorsFollowedDTO getVendorsFollow(int userId);
}
