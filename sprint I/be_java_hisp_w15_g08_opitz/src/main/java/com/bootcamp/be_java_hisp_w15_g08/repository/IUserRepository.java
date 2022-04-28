package com.bootcamp.be_java_hisp_w15_g08.repository;

import com.bootcamp.be_java_hisp_w15_g08.model.User;

public interface IUserRepository {
    User findUser(Integer id);
    void followUser(Integer idFollowed, Integer idFollower);
    void unFollowUser(Integer idFollowed, Integer idFollower);
    int generateId();
}
