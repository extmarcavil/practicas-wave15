package com.example.be_java_hisp_w15_g07.repository;

import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class UserRepository implements IUserRepository{
    private Map<Integer, User> database;

    public UserRepository() {
        this.database = new HashMap<>();
        initDatabase();
    }

    private void initDatabase(){
        // Create user.
        User user = new User(1, "User 1");
        // Add followers
        Set<Integer> followers = new TreeSet<>(Arrays.asList(2, 3));
        user.setFollowers(followers);
        // Add followed.
        Set<Integer> followed = new TreeSet<>(Arrays.asList(2, 3));
        user.setFollowers(followed);
        // Add user to database.
        database.put(user.getUserId(), user);

        user = new User(2, "User 2");
        followers = new TreeSet<>(Arrays.asList(1, 2));
        user.setFollowers(followers);
        database.put(user.getUserId(), user);

        user = new User(3, "User 3");
        followed = new TreeSet<>(Arrays.asList(1, 2, 3));
        user.setFollowers(followed);
        database.put(user.getUserId(), user);

        user = new User(4, "User 4");
        followers = new TreeSet<>(Arrays.asList(1, 2, 3));
        user.setFollowers(followers);
        followed = new TreeSet<>(Arrays.asList(2, 3));
        user.setFollowers(followed);
        database.put(user.getUserId(), user);

    }

    @Override
    public User findById(Integer id) {
        if(database.containsKey(id)){
            return database.get(id);
        }
        throw new UserNotFoundException("Usuario con id: " + id + " no encontrado");
    }

    public User getFollowersList(Integer userId) {
        return this.findById(userId);
    }
}
