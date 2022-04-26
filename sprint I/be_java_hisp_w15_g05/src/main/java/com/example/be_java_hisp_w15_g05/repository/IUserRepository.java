package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.User;

import java.util.Optional;

public interface IUserRepository {
    User findById(int id);
    boolean follow(int seguidor, int seguido);
    int cantFollowers(int id);
    Optional<User> followersList(int id);
}
