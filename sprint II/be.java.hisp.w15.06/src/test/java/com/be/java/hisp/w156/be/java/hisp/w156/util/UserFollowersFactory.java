package com.be.java.hisp.w156.be.java.hisp.w156.util;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserFollowersFactory {

    public static User getUser(int userId){
        User user = new User();
        List<User> follower = new ArrayList<>();
        follower.add(user);

        User user1 = new User(userId, "Julieta", follower);
        return user1;
    }
}
