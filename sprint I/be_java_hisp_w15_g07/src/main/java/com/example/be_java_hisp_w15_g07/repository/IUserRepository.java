package com.example.be_java_hisp_w15_g07.repository;

import com.example.be_java_hisp_w15_g07.model.User;

public interface IUserRepository {

    User findById(Integer id);

    User getFollowersList(Integer userId);
}
