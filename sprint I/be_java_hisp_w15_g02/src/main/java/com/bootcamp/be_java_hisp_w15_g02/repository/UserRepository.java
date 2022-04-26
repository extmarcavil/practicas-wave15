package com.bootcamp.be_java_hisp_w15_g02.repository;

import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> users;
    public UserRepository() {
        users = new ArrayList<>();
        createUsers();
    }

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
    public boolean follow(int userId, int userIdToFollow) {
        User user = null;
        User userToFollow = null;
        for(User u : users) {
            if (u.getUserId() == userId)
                user = u;
            if (u.getUserId() == userIdToFollow && u.isSeller())
                userToFollow = u;
        }

        if (user == null || userToFollow == null)
            return false;

        userToFollow.getFollowerList().add(new Follow(user.getUserId()));
        user.getFollowList().add(new Follow(userToFollow.getUserId()));


        for (User u : users) {
            System.out.println(u.getFollowerList());
        }
        return true;
    }

    @Override
    public void unfollow(int user_id, int user_to_unfollow) {

    }

    private void createUsers() {
        users.add(new User(users.size(), "user1"));
        User u1 = new User(users.size(), "user2");
        u1.setSeller(true);
        users.add(u1);
    }
}
