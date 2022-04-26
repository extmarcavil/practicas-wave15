package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.Model.User;

public interface IUserService {

    public UserDTO convertToDTo(User user);
}
