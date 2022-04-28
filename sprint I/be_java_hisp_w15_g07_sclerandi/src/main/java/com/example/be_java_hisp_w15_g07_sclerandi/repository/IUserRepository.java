package com.example.be_java_hisp_w15_g07_sclerandi.repository;

import com.example.be_java_hisp_w15_g07_sclerandi.model.Post;
import com.example.be_java_hisp_w15_g07_sclerandi.model.User;

import java.util.List;

public interface IUserRepository {

    User findById(Integer id);

    void newPost(Integer userId, Post unPost);

    List<User> findFollowersOrderByNameAsc(Integer userId);

    List<User> findFollowersOrderByNameDesc(Integer userId);

    List<User> findFollowedOrderByNameAsc(Integer userId);

    List<User> findFollowedOrderByNameDesc(Integer userId);
}
