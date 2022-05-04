package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserFollowedDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<SuccessDTO> follow(Integer userToFollow, Integer userId);

    ResponseEntity<SuccessDTO> unfollow(Integer userToFollow, Integer userId);

    ResponseEntity<UserCountFollowersDTO> getCountFollowers(Integer id);

    ResponseEntity<UserFollowersDTO> getFollowers(Integer id, String order);

    ResponseEntity<UserFollowedDTO> getFollowed(Integer id, String order);

}
