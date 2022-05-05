package com.be.java.hisp.w156.be.java.hisp.w156.utils;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostFactory {



    public static User getListPostLast2Weeks(){
        User user = new User();
        User userSeller = new User();

        List<User> followed = new ArrayList<>();
        followed.add(userSeller);
        user.setFollowed(followed);

        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        List<Post> posts = Stream.of(
                new Post(1, LocalDate.now(), product, "100", 500.50),
                new Post(1, LocalDate.now().minusDays(60), product, "100", 500.50),
                new Post(1, LocalDate.now().minusDays(15), product, "100", 600.50)
        ).collect(Collectors.toList());


        userSeller.setPosts(posts);

        return user;
    }

    public static List<ResponsePostDTO> getPosts(){
        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        List<ResponsePostDTO> posts2 = Stream.of(
                new Post(1, LocalDate.now(), product, "100", 500.50)
                ).map(ResponsePostDTO::from).collect(Collectors.toList()) ;

        return posts2;
    }

}
