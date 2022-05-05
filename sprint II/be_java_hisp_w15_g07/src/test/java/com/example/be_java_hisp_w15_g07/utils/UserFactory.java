package com.example.be_java_hisp_w15_g07.utils;

import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.Product;
import com.example.be_java_hisp_w15_g07.model.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class UserFactory {
    public static User getUserOne(){
        return new User(1, "User 1");
    }

    public static User getUserTwo(){
        User user2 = new User(2, "User 2");
        Product product = new Product(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        Post post = new Post(LocalDate.of(2020, Month.APRIL, 10), product, 1, 60000d);
        user2.newPost(post);
        return user2;
    }

    public static void setFollowedList(User user, User userToFollow){
        Set<User> followed = new HashSet<>();
        followed.add(userToFollow);
        user.setFollowed(followed);
        Set<User> follower = new HashSet<>();
        follower.add(user);
        userToFollow.setFollowers(follower);
    }
}
