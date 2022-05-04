package com.example.be_java_hisp_w15_g07_ravelli.repository;

import com.example.be_java_hisp_w15_g07_ravelli.model.Post;
import com.example.be_java_hisp_w15_g07_ravelli.model.User;

import java.util.List;

public interface IUserRepository {

    User findById(Integer id);

    void newPost(Integer userId, Post unPost);

    List<User> findFollowersOrderByNameAsc(Integer userId);

    List<User> findFollowersOrderByNameDesc(Integer userId);

    List<User> findFollowedOrderByNameAsc(Integer userId);

    List<User> findFollowedOrderByNameDesc(Integer userId);

    Long getPromoProductsCount(Integer userId);
}
