package com.be.java.hisp.w156.be.java.hisp.w156.utils;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.PostFactory.generatePosts;

public class UserFactory {

    public static User anUser() {
        return new User(1, "Pepe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public static User otherUser() {
        return new User(2, "Moni", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public static User anUserUnFollower() {
        ArrayList<User> listUsersFollowed = new ArrayList<>();
        ArrayList<User> listUserFollowers = new ArrayList<>();
        listUserFollowers.add(new User(1, "Pepe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        listUsersFollowed.add(anUser());

        return new User(2, "Moni2", new ArrayList<>(), listUserFollowers, listUsersFollowed);
    }

    public static User getUserWithPosts() {
        User user = new User();
        user.setId(1);

        List<User> listUserFollowed = new ArrayList<>();
        User userFollowed =  otherUser();
        userFollowed.setPosts(generatePosts());

        listUserFollowed.add(userFollowed);
        user.setFollowed(listUserFollowed);

        return user;
    }

}
