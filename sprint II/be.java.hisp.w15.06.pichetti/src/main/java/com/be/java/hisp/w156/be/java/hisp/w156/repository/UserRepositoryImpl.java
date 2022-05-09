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

    public UserRepositoryImpl() {
        initData();
    }

    private void initData() {
        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        List<Post> posts = Stream.of(
                new Post(1, LocalDate.now().minusDays(1), product, "100", 500.50),
                new Post(1, LocalDate.now().minusDays(20), product, "100", 600.50)
        ).collect(Collectors.toList());

        List<Post> posts2 = Stream.of(new Post(1, LocalDate.now().minusDays(25), product, "150", 100.50))
                .collect(Collectors.toList());

        User user1 = new User(1, "Pepe", new ArrayList<>(), new ArrayList<User>(), new ArrayList<User>());
        User user2 = new User(2, "Moni", posts, new ArrayList<User>(), new ArrayList<User>());
        User user3 = new User(3, "Dardo", posts2, new ArrayList<User>(), new ArrayList<User>());
        User user4 = new User(4, "Marialena", posts2, new ArrayList<User>(), new ArrayList<User>());

        user1.getFollowed().add(user3);
        user1.getFollowed().add(user4);
        user2.getFollowed().add(user3);
        user3.getFollowers().add(user1);
        user3.getFollowers().add(user2);

        user4.getFollowed().add(user2);
        user2.getFollowers().add(user4);

        users = Stream.of(
                user1,
                user2,
                user3,
                user4
        ).collect(Collectors.toList());
    }

    @Override
    public User getUser(Integer id) {
        return this.users.stream()
                .filter(x -> x.getId() == id)
                .findFirst().orElseThrow(() -> new UserNotFoundException(id));
    }

}
