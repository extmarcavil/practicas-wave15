package com.be.java.hisp.w156.be.java.hisp.w156.utils;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.util.ArrayList;

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

}
