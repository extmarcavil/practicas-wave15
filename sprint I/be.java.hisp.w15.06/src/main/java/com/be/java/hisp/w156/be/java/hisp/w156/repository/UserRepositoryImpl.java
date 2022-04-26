package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        List<Post> posts = List.of(
                new Post(1, LocalDate.of(2022, 4, 26), product, "100", 500.50),
                new Post(1, LocalDate.of(2022, 4, 12), product, "100", 600.50));
        List<Post> posts2 = List.of(new Post(1, LocalDate.of(2022, 4, 10), product, "150", 100.50));

        User user1 = new User(1, "Pepe", null, null, null);
        User user2 = new User(2, "Moni", posts, null, null);
        User user3 = new User(3, "Dardo", posts2, List.of(user1, user2), null);
        User user4 = new User(4, "Marialena", posts2, null, null);

        user1.setFollowed(new ArrayList<>(Arrays.asList(user3)));
        user2.setFollowed(new ArrayList<>(Arrays.asList(user3)));

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
                .findFirst().orElse(null);
    }

    @Override
    public void follow(Integer userToFollow, Integer userId) {

    }

    @Override
    public void unfollow(Integer userToFollow, Integer userId) {

    }

    @Override
    public Integer getCountFollow(Integer id) {
        User user = this.users.stream()
                .filter(x -> x.getId() == id)
                .findFirst().orElse(null);

        return user.getFollowers().size();
    }

    @Override
    public List<User> getFollowers(Integer id) {
        return null;
    }

    @Override
    public List<User> getFollowed(Integer id) {
        return null;
    }

    @Override
    public void savePost(Post post) {

    }

    @Override
    public List<Post> getPostsLastTwoWeekById(Integer id) {
        return null;
    }
}
