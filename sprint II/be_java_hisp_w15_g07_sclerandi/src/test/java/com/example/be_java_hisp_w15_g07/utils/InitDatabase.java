package com.example.be_java_hisp_w15_g07.utils;

import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.Product;
import com.example.be_java_hisp_w15_g07.model.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class InitDatabase {

    public static void initDatabase(Map<Integer, User> database){
        // Create user.
        User user1 = new User(1, "User 1");
        User user2 = new User(2, "User 2");
        User user3 = new User(3, "User 3");
        User user4 = new User(4, "User 4");

        Product product = new Product(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        Post post = new Post(LocalDate.of(2020, Month.APRIL, 10), product, 1, 60000d);
        user2.newPost(post);

        product = new Product(2, "Computadora", "Electrodomesticos", "Samsung", "Negro", "");
        post = new Post(LocalDate.of(2022, Month.APRIL, 20), product, 2, 100000d);
        user2.newPost(post);

        product = new Product(3, "Aire Acondicionado", "Electrodomesticos", "LG", "Blanco", "");
        post = new Post(LocalDate.of(2022, Month.APRIL, 26), product, 3, 87000d);
        user3.newPost(post);

        product = new Product(4, "Pava eléctrica", "Electrodomesticos", "Philip", "Negro", "");
        post = new Post(LocalDate.of(2020, Month.JUNE, 12), product, 4, 4000d);
        user3.newPost(post);

        product = new Product(5, "Heladera", "Electrodomesticos", "Samsung", "Blanca", "");
        post = new Post(LocalDate.of(2020, Month.JULY, 22), product, 5, 180000d);
        user4.newPost(post);

        // Add followers
        // User1 no es vendedor y no tiene seguidores.
        user1.addUserToFollow(user2);
        user2.addFollower(user1);

        user1.addUserToFollow(user3);
        user3.addFollower(user1);

        user3.addUserToFollow(user2);
        user2.addFollower(user3);

        // Add user to database.
        database.put(user1.getUserId(), user1);
        database.put(user2.getUserId(), user2);
        database.put(user3.getUserId(), user3);
        database.put(user4.getUserId(), user4);
    }
}
