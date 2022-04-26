package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.Model.User;

public interface IUserService {

    UserDTO convertToDTo(User user);
    UserWithFollowersCountDTO getUsersWithFollowersCount(int userId);
}
