package com.sprint.be_java_hisp_w15_g10.utils;

import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;

public class TestUtils {
    public static User createFollowedUser(UserRepository userRepository){
        User user1 = new User(4,"Luis");
        User user2 = new User(5,"David");
        User user3 = new User(6,"Alfredo");
        User user4 = new User(7,"Raúl");
        user1.agregarSeguidor(user2);
        user1.agregarSeguidor(user3);
        user1.agregarSeguidor(user4);
        user2.seguirUsuario(user1);
        user3.seguirUsuario(user1);
        user4.seguirUsuario(user1);
        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);
        userRepository.add(user4);
        return user1;
    }

    public static User createUser(int i, String name){
        return new User(i, name);
    }

    public static void FollowUser(User cliente, User vendedor){
        cliente.seguirUsuario(vendedor);
        vendedor.agregarSeguidor(cliente);
    }
}
