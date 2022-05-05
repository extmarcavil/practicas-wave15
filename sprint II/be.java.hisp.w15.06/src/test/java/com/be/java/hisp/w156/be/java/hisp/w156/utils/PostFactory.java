package com.be.java.hisp.w156.be.java.hisp.w156.utils;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostFactory {

    private static final Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");

    public static User getListPostLast2Weeks(){
        User user = new User();
        User userSeller = new User();

        List<User> followed = new ArrayList<>();
        followed.add(userSeller);
        user.setFollowed(followed);

        List<Post> posts = generatePosts();

        userSeller.setPosts(posts);

        return user;
    }

    public static List<ResponsePostDTO> getPosts(){
        return generatePosts().stream()
                .map(ResponsePostDTO::from)
                .collect(Collectors.toList());
    }

    public static List<ResponsePostDTO> getPostsOrderByAsc() {
        return generatePosts().stream()
                .map(ResponsePostDTO::from)
                .sorted(Comparator.comparing(ResponsePostDTO::getDate))
                .collect(Collectors.toList());
    }

    public static List<ResponsePostDTO> getPostsOrderByDesc() {
        return generatePosts().stream()
                .map(ResponsePostDTO::from)
                .sorted(Comparator.comparing(ResponsePostDTO::getDate).reversed())
                .collect(Collectors.toList());
    }

    public static List<Post> generatePosts() {
        return Stream.of(
                new Post(1, LocalDate.now().minusDays(1), product, "100", 500.50),
                new Post(1, LocalDate.now(), product, "100", 500.50)
        ).collect(Collectors.toList());
    }

}
