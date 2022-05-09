package com.be.java.hisp.w156.be.java.hisp.w156.utils;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.PostFactory.generatePosts;

public class UserFactory {

    public static List<UserDTO> getUserDTOS() {
        return List.of(new UserDTO(1, "Pepe"), new UserDTO(2, "Moni"));
    }

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

        User userFollowed2 =  otherUser();
        userFollowed.setPosts(generatePosts());

        listUserFollowed.add(userFollowed);
        listUserFollowed.add(userFollowed2);
        user.setFollowed(listUserFollowed);

        return user;
    }

    public static User getUserWithFolloweds() {
        User user = anUser();
        user.setFollowed(List.of(anUser(), otherUser()));

        return user;
    }

    public static User getUserWithFollowers() {
        User user = anUser();
        user.setFollowers(List.of(anUser(), otherUser()));

        return user;
    }

    public static List<UserDTO> getUserDtoOrderByAsc() {
        return getUserDTOS().stream()
                .sorted(Comparator.comparing(UserDTO::getUser_name))
                .collect(Collectors.toList());
    }

    public static List<UserDTO> getUserDtoOrderByDesc() {
        return getUserDTOS().stream()
                .sorted(Comparator.comparing(UserDTO::getUser_name).reversed())
                .collect(Collectors.toList());
    }

}
