package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();
    private Integer postContador = 0;

    public UserRepository() {
        initializeData();
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst();
    }

    @Override
    public void follow(User user, User seller) {
        seller.addFollower(user);
        user.follow(seller);
    }

    @Override
    public void unFollow(User user, User seller) {
        seller.deleteFollower(user);
        user.unfollow(seller);
    }

    @Override
    public int countFollowers(User user) {
        return user.getFollowers().size();
    }

    @Override
    public void createPost(User user, Post post) {
        post.setPostId(postContador ++);
        posts.add(post);
        user.setSeller(true);
    }

    @Override
    public List<Post> getPostsTwoWeeks(int id){
        return posts.stream()
                .filter(post -> post.getUserId() == id && inTwoWeeksRange(post.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPromoPosts(int userId) {
        return posts.stream()
                .filter(post -> post.getUserId() == userId && post.isHasPromo())
                .collect(Collectors.toList());
    }

    private void initializeData() {
        User galperin = new User(1, "Marcos Galperin", true);
        User antonio = new User(2, "Antonio", true);
        User juan = new User(10, "Juan", false);
        User pedro = new User(11, "APedro", false);
        User valentina = new User(12, "Valentina", false);

        galperin.addFollower(juan);
        juan.follow(galperin);

        galperin.addFollower(pedro);
        pedro.follow(galperin);

        antonio.addFollower(juan);
        juan.follow(antonio);

        users.add(galperin);
        users.add(antonio);
        users.add(juan);
        users.add(pedro);
        users.add(valentina);

        Post posteo = new Post(1,20,LocalDate.of(2022,4,1),null,100,202.00, false, 0);
        Post posteo2 = new Post(1,21,LocalDate.of(2022,4,26),null,100,202.00, false, 0);
        Post posteo3 = new Post(1,22,LocalDate.of(2022,4,24),null,100,202.00, false, 0);
        Post posteo4 = new Post(1,23,LocalDate.of(2022,4,25),null,100,202.00, false, 0);

        posts.addAll(Arrays.asList(posteo,posteo2,posteo3,posteo4));
    }

    private boolean inTwoWeeksRange(LocalDate fecha){
        long differencesInDays = ChronoUnit.DAYS.between( fecha , LocalDate.now() );
        return differencesInDays < 14 && differencesInDays >= 0;
    }

}
