package com.bootcamp.be_java_hisp_w15_g02.unit.utils;

import com.bootcamp.be_java_hisp_w15_g02.dto.response.PostsBySellersDTO;
import com.bootcamp.be_java_hisp_w15_g02.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.bootcamp.be_java_hisp_w15_g02.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Global {

    public static List<User> getListOfUsers(){
        List<User> listUser = new ArrayList<>();
        List<Follow> listFollowers = new ArrayList<>();
        List<Follow> listFollowers2 = new ArrayList<>();
        List<Follow> listFollows = new ArrayList<>();
        List<Follow> listFollows2 = new ArrayList<>();

        listFollows.add(new Follow(5));

        listFollows2.add(new Follow(5));

        listFollowers.add(new Follow(1));
        listFollowers.add(new Follow(3));

        listFollowers2.add(new Follow(1));
        listFollowers2.add(new Follow(2));
        listFollowers2.add(new Follow(3));

        User user4 = new User(4, "Carlos", new ArrayList<>(), listFollowers);
        User user5 = new User(5, "Ramiro", listFollows2, listFollowers2);
        user4.setSeller(true);
        user5.setSeller(true);
        listUser.add(new User(1, "Martin", listFollows, new ArrayList<>()));
        listUser.add(new User(2, "Leo", listFollows2, new ArrayList<>()));
        listUser.add(new User(3, "Diana", listFollows, new ArrayList<>()));
        listUser.add(user4);
        listUser.add(user5);

        return listUser;
    }

    public static List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(4,5, LocalDate.parse("2022-04-10"),4,new Product(4,"iphone se","electronic","apple","red","iphone 64 GB"),7000));
        posts.add(new Post(5,5, LocalDate.now(),5,new Product(5,"iphone XR","electronic","apple","white","iphone 128 GB"),5000));
        posts.add(new Post(6,5, LocalDate.parse("2022-05-03"),5,new Product(6,"cama","electronic","apple","white","cama grande"),6000));
        return posts;
    }

    public static List<PostsBySellersDTO> getRecentPostsDesc() {
        List<PostsBySellersDTO> posts = new ArrayList<>();
        posts.add(
                new PostsBySellersDTO(
                        new Post(5,5, LocalDate.now(),5,
                                new Product(5,"iphone XR","electronic","apple","white",
                                        "iphone 128 GB"),5000)));
        posts.add(new PostsBySellersDTO(
                new Post(6,5, LocalDate.parse("2022-05-03"),5,
                        new Product(6,"cama","electronic","apple","white","cama grande"),
                        6000)));
        return posts;
    }

    public static List<PostsBySellersDTO> getRecentPostsAsc() {
        List<PostsBySellersDTO> posts = new ArrayList<>();
        posts.add(new PostsBySellersDTO(
                new Post(6,5, LocalDate.parse("2022-05-03"),5,
                        new Product(6,"cama","electronic","apple","white","cama grande"),
                        6000)));
        posts.add(
                new PostsBySellersDTO(
                        new Post(5,5, LocalDate.now(),5,
                                new Product(5,"iphone XR","electronic","apple","white",
                                        "iphone 128 GB"),5000)));
        return posts;
    }

    public static User getUserByIdUtils(int userId){

        return getListOfUsers().stream().
                filter(f -> f.getUserId() == userId)
                .findFirst().orElseThrow(UserNotFoundException::new);
    }
}
