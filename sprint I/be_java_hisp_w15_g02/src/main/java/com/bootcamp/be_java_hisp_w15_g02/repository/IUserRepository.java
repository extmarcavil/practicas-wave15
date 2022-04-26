package com.bootcamp.be_java_hisp_w15_g02.repository;

import com.bootcamp.be_java_hisp_w15_g02.model.User;

import java.util.List;

public interface IUserRepository {
    boolean createUser(User user);
    List<User> getListUser();
    User getUserById(int user_id);
    boolean follow(int user_id, int user_to_follow);
    void unfollow(int user_id, int user_to_unfollow);

}
