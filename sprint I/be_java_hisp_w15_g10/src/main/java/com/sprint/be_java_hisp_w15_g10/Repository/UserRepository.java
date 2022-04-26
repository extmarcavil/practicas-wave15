package com.sprint.be_java_hisp_w15_g10.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> usuarios;

    UserRepository(){

        User user1 = new User(1, "Alejandro");
        User user2 = new User(2, "Camilo");
        User user3 = new User(3, "Luis");

        List<User> followers1 = ArrayList<>
    }
}
