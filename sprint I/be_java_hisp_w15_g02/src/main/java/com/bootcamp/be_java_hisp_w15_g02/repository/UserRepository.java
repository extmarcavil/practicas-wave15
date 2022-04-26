package com.bootcamp.be_java_hisp_w15_g02.repository;

import com.bootcamp.be_java_hisp_w15_g02.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public List<User> getListUser() {
        return null;
    }

    @Override
    public User getUserById(int user_id) {
        return null;
    }

    @Override
    public void follow(int user_id, int user_to_follow) {

    }

    @Override
    public void unfollow(int user_id, int user_to_unfollow) {

    }
}
