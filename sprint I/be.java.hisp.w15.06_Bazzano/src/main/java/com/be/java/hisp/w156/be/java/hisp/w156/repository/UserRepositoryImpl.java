package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private List<User> users;
    private List<Product> products;
    public UserRepositoryImpl() {
        initData();
    }

    @Override
    public void initData() {
        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Product product2 = new Product(2, "Lampara Escritorio", "Lampara", "Racer", "Black", "Special Edition");
        Product product3 = new Product(3, "Auriculares", "Sonido", "Racer", "Black", "Special Edition");
        Product product4 = new Product(3, "Teclado", "teclado", "Racer", "Black", "Special Edition");

        List<Post> posts = Stream.of(
                new Post(1, LocalDate.of(2022, 4, 26), product, "100", 500.50, false, null),
                new Post(1, LocalDate.of(2022, 4, 12), product, "100", 600.50, false, null)
        ).collect(Collectors.toList());

        List<Post> posts2 = Stream.of(new Post(1, LocalDate.of(2022, 4, 15), product, "150", 100.50, false, null))
                .collect(Collectors.toList());
        List<Post> posts3 = Stream.of(new Post(1, LocalDate.of(2022, 4, 15), product, "150", 100.50, true, 0.25),
                                      new Post(2, LocalDate.of(2022, 4, 10), product3, "80", 50.50, false, null),
                                      new Post(3, LocalDate.of(2022, 3, 30), product2, "150", 550.50, true, 0.5),
                                      new Post(4, LocalDate.of(2021, 2, 27), product4, "80", 400.50, true, 0.1))

                .collect(Collectors.toList());

        User user1 = new User(1, "Pepe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Moni", posts, new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "Dardo", posts2, new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4, "Marialena", posts2, new ArrayList<>(), new ArrayList<>());
        User user5 = new User(5, "Paola", posts3, new ArrayList<>(), new ArrayList<>());

        user1.getFollowed().add(user3);
        user2.getFollowed().add(user3);
        user3.getFollowers().add(user1);
        user3.getFollowers().add(user2);
        user5.getFollowers().add(user1);
        users = Stream.of(
                user1,
                user2,
                user3,
                user4,
                user5
        ).collect(Collectors.toList());
    }

    @Override
    public User getUser(Integer id) {
        return this.users.stream()
                .filter(x -> x.getId() == id)
                .findFirst().orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public boolean existsById(Integer id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }
}
