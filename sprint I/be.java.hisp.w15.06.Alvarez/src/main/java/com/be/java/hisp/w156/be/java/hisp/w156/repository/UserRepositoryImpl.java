package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.PromoPost;
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

    @Override
    public void initData() {
        Product product1 = new Product(2, "A - Teclado Gamer", "Gamer", "Dragon", "Blue & Green", "Black Edition");
        Product product2 = new Product(2, "B - Mouse Gamer", "Gamer", "HP", "Red", "Red Edition");

        List<PromoPost> promoPosts1 = Stream.of(
                new PromoPost(1, LocalDate.of(2022, 4, 23), product1, "50", 1000.50, true, 100),
                new PromoPost(2, LocalDate.of(2022, 4, 27), product2, "50", 1000.50, true, 150)
        ).collect(Collectors.toList());

        List<PromoPost> promoPosts2 = Stream.of(
                new PromoPost(3, LocalDate.of(2022, 4, 14), product1, "50", 500.50, true, 50),
                new PromoPost(4, LocalDate.of(2022, 4, 17), product2, "50", 500.50, true, 25)
        ).collect(Collectors.toList());

        User user5 = new User(5, "Matute" ,new ArrayList<>(),  new ArrayList<User>(), new ArrayList<User>(), promoPosts1);
        User user6 = new User(6, "Flor" ,new ArrayList<>(),  new ArrayList<User>(), new ArrayList<User>(), promoPosts2);

        user5.getFollowers().add(user6);

        users = Stream.of(
                user5,
                user6
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
