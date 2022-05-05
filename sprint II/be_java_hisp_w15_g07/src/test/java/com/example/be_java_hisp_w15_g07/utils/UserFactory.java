package com.example.be_java_hisp_w15_g07.utils;

import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowersDTO;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.Product;
import com.example.be_java_hisp_w15_g07.model.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class UserFactory {
    public static User getUserOne(){
        return new User(1, "User 1");
    }

    public static UserFollowersDTO getUserOneDTO(){
        return new UserFollowersDTO(1, "User 1");
    }

    public static User getUserTwo(){
        User user2 = new User(2, "User 2");

        // Add post
        Product product = new Product(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        Post post = new Post(LocalDate.of(2020, Month.APRIL, 10), product, 1, 60000d);
        user2.newPost(post);

        // Add follower
        User user1 = getUserOne();
        User user3 = getUserThree();
        user1.addUserToFollow(user2);
        user3.addUserToFollow(user2);
        user2.addFollower(user1);
        user2.addFollower(user3);

        return user2;
    }

    public static User getUserThree(){
        return new User(3, "User 3");
    }

    public static UserFollowersDTO getUserThreeDTO(){
        return new UserFollowersDTO(3, "User 3");
    }

    public static FollowersDTO getFollowersDTOAsc(){
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserID(2);
        followersDTO.setUserName("User 2");
        List<UserFollowersDTO> followers = Arrays.asList(UserFactory.getUserOneDTO(), UserFactory.getUserThreeDTO());
        followersDTO.setFollowers(followers);
        return followersDTO;
    }

    public static FollowersDTO getFollowersDTODesc(){
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserID(2);
        followersDTO.setUserName("User 2");
        List<UserFollowersDTO> followers = Arrays.asList(UserFactory.getUserThreeDTO(), UserFactory.getUserOneDTO());
        followersDTO.setFollowers(followers);
        return followersDTO;
    }
}
