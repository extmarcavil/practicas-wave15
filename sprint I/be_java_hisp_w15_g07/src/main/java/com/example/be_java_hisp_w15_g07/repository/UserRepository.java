package com.example.be_java_hisp_w15_g07.repository;

import com.example.be_java_hisp_w15_g07.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository{
    private Map<Integer, User> database;

    public UserRepository() {
        this.database = new HashMap<>();
        initDatabase();
    }

    private void initDatabase(){
        User user = new User(1, "User 1");
        database.put(user.getUserId(), user);
        user = new User(2, "User 2");
        database.put(user.getUserId(), user);
        user = new User(3, "User 3");
        database.put(user.getUserId(), user);
    }
}
