package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void follow(Integer userId, Integer userToFollow) {
        userRepository.follow(userId,userToFollow);
    }

    @Override
    public void unfollow(Integer userId, Integer userToUnfollow) {
        userRepository.unfollow(userId,userToUnfollow);
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
