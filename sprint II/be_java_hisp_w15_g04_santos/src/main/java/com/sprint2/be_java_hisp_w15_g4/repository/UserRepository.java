package com.sprint2.be_java_hisp_w15_g4.repository;

import com.sprint2.be_java_hisp_w15_g4.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> users;

    public UserRepository() {
        this.users = createUsers();
    }

    private List<User> createUsers() {
        List<User> userList = new ArrayList<>();

        User user1 = new User(1, "nombre1");
        User user2 = new User(2, "nombre2");

        user1.addFollowing(user2);
        user2.addFollower(user1);

        userList.add(user1);
        userList.add(user2);
        userList.add(new User(3, "nombre3"));
        userList.add(new User(4, "nombre4"));

        return  userList;
    }

    @Override
    public User findUser(int id) {
        return users.stream().filter(u -> u.getUser_id() == id).findFirst().orElse(null);
    }

    public void saveUser(User user) {
        this.users.add(user);
    }

    public void cleanAll() { this.users.clear(); }

    public List<User> getAll() { return this.users; }

}
