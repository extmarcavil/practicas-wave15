package com.bootcamp.be_java_hisp_w15_g08.repository;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private Map<Integer, User> users;

    public UserRepository() {
        users = new HashMap<>();
        initData();
    }

    private void initData() {
        User user1 = new User(1234,"Cosme Fulanito");
        User user2 = new User(1235,"Max Power");
        User user3 = new User(1236,"Homer Thompson");
        User user4 = new User(1237,"Mister Json");

        users.put(user1.getUserID(),user1);
        users.put(user2.getUserID(),user2);
        users.put(user3.getUserID(),user3);
        users.put(user4.getUserID(),user4);
        user1.addFollower(user2);
        user1.addFollower(user3);
    }

    @Override
    public User findUser(Integer id){
        return Optional.ofNullable(users.get(id)).orElseThrow(()-> new UserNotFoundException("The user id"+ id + " doesn't exist"));
    }

    @Override
    public void followUser(Integer idFollowed, Integer idFollower){
        User followed = findUser(idFollowed);
        User follower = findUser(idFollower);

        followed.addFollower(follower);
        follower.addFollowed(followed);

        //Esto es solo para testear hay que borrarlo.
        System.out.println(followed.getFollowers().size());
    }

    @Override
    public void unFollowUser(Integer idFollowed, Integer idFollower){
        User followed = findUser(idFollowed);
        User follower = findUser(idFollower);

        followed.removeFollower(follower);
        follower.removeFollowed(followed);
    }
}
