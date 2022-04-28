package com.sprint1.be_java_hisp_w15_g4.repository;

import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = createUsers();
    }

    private List<User> createUsers() {
        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "zzzz"));
        userList.add(new User(2, "bbbb"));
        userList.add(new User(3, "aaaa"));
        userList.add(new User(4, "ddddd"));

        return  userList;
    }

    @Override
    public User findUser(int id) {
        return users.stream().filter(u -> u.getUser_id() == id).findFirst().orElse(null);
    }

}
