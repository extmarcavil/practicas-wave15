package com.bootcamp.be_java_hisp_w15_g08.repository;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g08.model.Post;
import com.bootcamp.be_java_hisp_w15_g08.model.PostDetail;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private Map<Integer, User> users;

    public UserRepository() {
        users = new HashMap<>();
        initData();
    }

    private void initData() {
        User user1 = new User(1234, "Cosme Fulanito");
        User user2 = new User(1235, "Max Power");
        User user3 = new User(1236, "Homer Thompson");
        User user4 = new User(1237, "Mister Json");



        //------------------------------------------------------------------------------------

        PostDetail postDetail1 = new PostDetail(1, "Gallinas", "Farmer", "Criolla", "Yellow and Orange", "Gallina ponedora");
        PostDetail postDetail2 = new PostDetail(2, "Silla", "Gamer", "Racer", "Red and Blac", "Special Edition");
        PostDetail postDetail3 = new PostDetail(3, "Mouse", "Office", "HP", "Bluel", "Optical");
        PostDetail postDetail4 = new PostDetail(4, "Teclado", "Office", "Acer", "Black", "Mechanic");
        PostDetail postDetail5 = new PostDetail(5, "Monitor", "Office", "Asus", "Red", "LCD");

        Post post1 = new Post(1, LocalDate.now().minusDays(4), postDetail1, 10, 10000);
        Post post2 = new Post(2, LocalDate.now().minusDays(1), postDetail2, 11, 15000);
        Post post3 = new Post(3, LocalDate.now().minusDays(3), postDetail3, 12, 20000);
        Post post4 = new Post(4, LocalDate.now().minusDays(400), postDetail4, 13, 25000);
        Post post5 = new Post(5, LocalDate.now().minusDays(500), postDetail5, 14, 30000);

        Map<Integer, Post> post = new HashMap<>();
        post.put(1, post1);
        post.put(2, post2);
        post.put(3, post3);
        post.put(4, post4);
        post.put(5, post5);

        user2.setPosts(post);

        List<User> list = new ArrayList<>();
        list.add(user3);
        list.add(user4);

        List<User> list2 = new ArrayList<>();
        list2.add(user2);

        user1.setFollowers(list);
        user1.setFollowing(list2); //Aqui vamos a meter el de los post.

        //---------------------------------------------------------------------------

        users.put(user1.getUserID(), user1);
        users.put(user2.getUserID(), user2);
        users.put(user3.getUserID(), user3);
        users.put(user4.getUserID(), user4);
    }

    @Override
    public User findUser(Integer id) {
        return Optional.ofNullable(users.get(id)).orElseThrow(() -> new UserNotFoundException("The user id" + id + " doesn't exist"));
    }

    @Override
    public void followUser(Integer idFollowed, Integer idFollower) {
        User followed = findUser(idFollowed);
        User follower = findUser(idFollower);

        followed.addFollower(follower);
        follower.addFollowed(followed);

        //Esto es solo para testear hay que borrarlo.
        System.out.println(followed.getFollowers().size());
    }

    @Override
    public void unFollowUser(Integer idFollowed, Integer idFollower) {
        User followed = findUser(idFollowed);
        User follower = findUser(idFollower);

        followed.removeFollower(follower);
        follower.removeFollowed(followed);
    }
}
