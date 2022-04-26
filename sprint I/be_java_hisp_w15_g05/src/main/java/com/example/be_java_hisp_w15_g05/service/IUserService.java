package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;

import java.util.List;

public interface IUserService {
    ResFollowPostDTO follow(int userId, int userToFollowId);

    List<ResListFollowersDTO> getListFollowers(int userId);
}
