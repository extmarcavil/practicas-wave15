package com.example.be_java_hisp_w15_g07.repository;

import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.Product;
import com.example.be_java_hisp_w15_g07.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class UserRepository implements IUserRepository{
    private Map<Integer, User> database;

    public UserRepository() {
        this.database = new HashMap<>();
        initDatabase();
    }

    private void initDatabase(){
        // Create user.
        User user1 = new User(1, "User 1");
        User user2 = new User(2, "User 2");
        User user3 = new User(3, "User 3");
        User user4 = new User(4, "User 4");

        Product product = new Product(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        Post post = new Post(LocalDate.of(2020, Month.APRIL, 10), product, 1, 60000d);
        user2.newPost(post);

        product = new Product(2, "Computadora", "Electrodomesticos", "Samsung", "Negro", "");
        post = new Post(LocalDate.of(2022, Month.APRIL, 10), product, 2, 100000d);
        user2.newPost(post);

        product = new Product(3, "Aire Acondicionado", "Electrodomesticos", "LG", "Blanco", "");
        post = new Post(LocalDate.of(2022, Month.MARCH, 17), product, 3, 87000d);
        user3.newPost(post);

        product = new Product(4, "Pava eléctrica", "Electrodomesticos", "Philip", "Negro", "");
        post = new Post(LocalDate.of(2020, Month.JUNE, 12), product, 4, 4000d);
        user3.newPost(post);

        // Add followers
        // User1 no es vendedor y no tiene seguidores.
        user1.addUserToFollow(user2);
        user2.addFollower(user1);

        user1.addUserToFollow(user3);
        user3.addFollower(user1);

        // Add user to database.
        database.put(user1.getUserId(), user1);


        user3.addUserToFollow(user2);
        user2.addFollower(user3);
        database.put(user3.getUserId(), user3);

        database.put(user2.getUserId(), user2);


        product = new Product(5, "Heladera", "Electrodomesticos", "Samsung", "Blanca", "");
        post = new Post(LocalDate.of(2020, Month.JULY, 22), product, 5, 180000d);
        user4.newPost(post);
        database.put(user4.getUserId(), user4);
        /*


        product = new Product(6, "Celular", "Electronica", "Motorola", "Blanco", "");
        post = new Post(6, 1, LocalDate.of(2021, Month.DECEMBER, 2), product, 6, 87000d);
        database.put(post.getPostId(), post);

        product = new Product(7, "Tostadora", "Electrodomesticos", "Volkswagen", "Blanco", "4 modos");
        post = new Post(7, 3, LocalDate.of(2022, Month.APRIL, 3), product, 7, 20000d);
        database.put(post.getPostId(), post);

        product = new Product(8, "Pantalla 50", "Electrodomesticos", "TopHouse", "Plateado", "");
        post = new Post(8, 2, LocalDate.of(2020, Month.APRIL, 10), product, 8, 68000d);
        database.put(post.getPostId(), post);
        */
    }

    @Override
    public User findById(Integer id) {
        if(database.containsKey(id)){
            return database.get(id);
        }
        throw new UserNotFoundException("Usuario con id: " + id + " no encontrado");
    }

    public User getFollowersList(Integer userId) {
        return this.findById(userId);
    }

    public void newPost(Integer userId, Post unPost){
        User user = this.findById(userId);
        user.newPost(unPost);
    }

}
