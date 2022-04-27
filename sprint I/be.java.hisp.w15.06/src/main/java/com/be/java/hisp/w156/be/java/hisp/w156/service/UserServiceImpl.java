package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void follow(Integer userToFollow, Integer userId) {

    }

    @Override
    public void unfollow(Integer userToFollow, Integer userId) {

    }

    @Override
    public Integer getCountFollow(Integer id) {
        return null;
    }

    @Override
    public List<User> getFollowers(Integer id) {
        return null;
    }

    @Override
    public List<User> getFollowed(Integer id) {
        return null;
    }

}
