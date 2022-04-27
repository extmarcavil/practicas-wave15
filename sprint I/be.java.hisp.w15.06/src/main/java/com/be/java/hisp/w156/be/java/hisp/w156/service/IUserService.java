package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowedDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    ResponseEntity<SuccessDTO> follow(Integer userToFollow, Integer userId);

    ResponseEntity<SuccessDTO> unfollow(Integer userToFollow, Integer userId);

    UserCountFollowersDTO getCountFollowers(Integer id);

    UserFollowersDTO getFollowers(Integer id, String order);

    UserFollowedDTO getFollowed(Integer id, String order);

}
