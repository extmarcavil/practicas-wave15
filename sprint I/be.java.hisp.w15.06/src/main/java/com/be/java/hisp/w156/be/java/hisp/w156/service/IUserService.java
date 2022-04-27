package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.util.List;

public interface IUserService {

    User getUser();

    void follow(Integer userToFollow, Integer userId);

    void unfollow(Integer userToFollow, Integer userId);

    Integer getCountFollow(Integer id);

    List<User> getFollowers(Integer id);

    List<User> getFollowed(Integer id);

}
