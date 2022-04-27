package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        List<Post> posts2 = List.of(new Post(1, LocalDate.of(2022, 4, 15), product, "150", 100.50));

        User user1 = new User(1, "Pepe", null, new ArrayList<User>(), new ArrayList<User>());
        User user2 = new User(2, "Moni", posts, new ArrayList<User>(), new ArrayList<User>());
        User user3 = new User(3, "Dardo", posts2, new ArrayList<User>(), new ArrayList<User>());
        User user4 = new User(4, "Marialena", posts2, new ArrayList<User>(), new ArrayList<User>());

        user1.getFollowed().add(user3);
        user2.getFollowed().add(user3);
        user3.getFollowers().add(user1);
        user3.getFollowers().add(user2);

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
                .findFirst().orElseThrow(() -> new UserNotFoundException("Usuario " + id + " no encontrado"));
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {

        User user = users.stream().filter(id -> id.getId() == userId).findFirst().orElse(null);
        User userToFollow = users.stream().filter(id -> id.getId() == userIdToFollow).findFirst().orElse(null);

        if(Objects.isNull(user))
            throw new UserNotFoundException("Usuario " + userId + " no encontrado");

        if(Objects.isNull(userToFollow))
            throw new UserNotFoundException("Usuario " + userIdToFollow + " no encontrado");

        if(userId == userIdToFollow)
            throw new UserNotFoundException("El usuario no puede seguirse a si mismo");

        List<User> followed = user.getFollowed();

        if(followed.contains(userToFollow))
            throw new UserNotFoundException("El usuario " + userId + " ya estaba siguiendo al usuario " + userIdToFollow);

        followed.add(userToFollow);
        user.setFollowed(followed);

        List<User> followers = userToFollow.getFollowers();
        followers.add(user);
        userToFollow.setFollowers(followers);

    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {

        User user = users.stream().filter(id -> id.getId() == userId).findFirst().orElse(null);
        User userToUnfollow = users.stream().filter(id -> id.getId() == userIdToUnfollow).findFirst().orElse(null);

        if(Objects.isNull(user))
            throw new UserNotFoundException("Usuario " + userId + " no encontrado");

        if(Objects.isNull(userToUnfollow))
            throw new UserNotFoundException("Usuario " + userIdToUnfollow + " no encontrado");

        List<User> followed = user.getFollowed();
        if(!followed.contains(userToUnfollow))
            throw new UserNotFoundException("El usuario " + userId + " no seguia al usuario " + userIdToUnfollow);

        followed.remove(userToUnfollow);
        user.setFollowed(followed);

        List<User> followers = userToUnfollow.getFollowers();
        followers.remove(user);
        userToUnfollow.setFollowers(followers);
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

    @Override
    public boolean existsById(Integer id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }
}
