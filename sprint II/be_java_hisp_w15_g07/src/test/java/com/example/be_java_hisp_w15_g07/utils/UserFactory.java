package com.example.be_java_hisp_w15_g07.utils;

import com.example.be_java_hisp_w15_g07.dto.request.ProductDTO;
import com.example.be_java_hisp_w15_g07.dto.response.*;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.Product;
import com.example.be_java_hisp_w15_g07.model.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserFactory {
    public static User getUserOne(){
        return new User(1, "User 1");
    }
    public static User getUserOneWithFollowed(){
        User user = new User(1, "User 1");
        Set<User> followed = new TreeSet<>();
        followed.add(getUserTwo());
        followed.add(getUserThree());
        user.setFollowed(followed);
        return user;
    }

    public static UserFollowersDTO getUserOneDTO(){
        return new UserFollowersDTO(1, "User 1");
    }
    public static UserFollowersDTO getUserTwoDTO(){
        return new UserFollowersDTO(2, "User 2");
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

    public static UserFollowedPostsDTO getUserTwoFollowedDTO(){
        UserFollowedPostsDTO user2 = new UserFollowedPostsDTO();
        ProductDTO product = new ProductDTO(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        PostDTO post = new PostDTO(10, LocalDate.of(2022, Month.MAY, 2), product, 1, 60000d);
        user2.setPosts(Arrays.asList(post));
        user2.setUserID(2);

        return user2;
    }

     public static UserFollowedPostsDTO getUserThreeFollowedDTO(){
        UserFollowedPostsDTO user3 = new UserFollowedPostsDTO();
        ProductDTO product = new ProductDTO(1, "Televisor 32", "Electrodomesticos", "Samsung", "Blanco", "");
        PostDTO post = new PostDTO(11, LocalDate.of(2022, Month.MAY, 4), product, 1, 60000d);
        user3.setPosts(Arrays.asList(post));
        user3.setUserID(3);

        return user3;
    }

    public static UserFollowedPostsDTO getUserOneFollowedDTOAsc(){
        UserFollowedPostsDTO user1 = new UserFollowedPostsDTO();

        ProductDTO product1 = new ProductDTO(1, "Televisor 32", "Electrodomesticos", "Samsung", "Blanco", "");
        PostDTO post1 = new PostDTO(11, LocalDate.of(2022, Month.MAY, 2), product1, 1, 60000d);

        ProductDTO product2 = new ProductDTO(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        PostDTO post2 = new PostDTO(10, LocalDate.of(2022, Month.MAY, 4), product2, 1, 60000d);

        user1.setPosts(Arrays.asList(post1,post2));
        user1.setUserID(1);

        return user1;
    }

    public static User getUserOneComplete(){
        User user = new User(1, "user 1");
        Set<User> followed = new TreeSet<>();
        followed.add(getUserTwo());
        followed.add(getUserThree());
        user.setFollowed(followed);

        return user;
    }

    public static UserFollowedPostsDTO getUserOneFollowedDTODesc(){
        UserFollowedPostsDTO user1 = new UserFollowedPostsDTO();

        ProductDTO product1 = new ProductDTO(1, "Televisor 32", "Electrodomesticos", "Samsung", "Blanco", "");
        PostDTO post1 = new PostDTO(11, LocalDate.of(2022, Month.MAY, 4), product1, 1, 60000d);

        ProductDTO product2 = new ProductDTO(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        PostDTO post2 = new PostDTO(10, LocalDate.of(2022, Month.MAY, 2), product2, 1, 60000d);

        user1.setPosts(Arrays.asList(post1,post2));
        user1.setUserID(1);

        return user1;
    }

    public static FollowedDTO getFollowedDTOAsc(){
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUserID(1);
        followedDTO.setUserName("User 1");
        List<UserFollowersDTO> followed = Arrays.asList(UserFactory.getUserTwoDTO(), UserFactory.getUserThreeDTO());
        followedDTO.setFollowed(followed);
        return followedDTO;
    }

    public static FollowedDTO getFollowedDTODesc(){
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUserID(1);
        followedDTO.setUserName("User 1");
        List<UserFollowersDTO> followed = Arrays.asList(UserFactory.getUserThreeDTO(), UserFactory.getUserTwoDTO());
        followedDTO.setFollowed(followed);
        return followedDTO;
    }

    public static User getUserFour(){
        return new User(4, "User 4");
    }
}
