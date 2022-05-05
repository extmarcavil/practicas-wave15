package com.example.be_java_hisp_w15_g05.utils;

import com.example.be_java_hisp_w15_g05.dto.UserDTO;
import com.example.be_java_hisp_w15_g05.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersFactory {
    private static User notSeller1 = new User(10, "Juan", false);
    private static User notSeller2 = new User(11, "APedro", false);
    private static User notSeller3 = new User(12, "Valentina", false);

    public static User createUser(){
        User user = new User(90,"test user",true);

        user.agregarSeguidor(notSeller1);
        user.agregarSeguidor(notSeller2);
        user.agregarSeguidor(notSeller3);

        return user;
    }

    public static List<UserDTO> listaOrdenadaAlfAsc(){
        return Arrays.asList(
                new UserDTO(notSeller2.getUserId(), notSeller2.getName()),
                new UserDTO(notSeller1.getUserId(), notSeller1.getName()),
                new UserDTO(notSeller3.getUserId(), notSeller3.getName())
        );
    }

    public static List<UserDTO> listaOrdenadaAlfDesc(){
        return Arrays.asList(
                new UserDTO(notSeller3.getUserId(), notSeller3.getName()),
                new UserDTO(notSeller1.getUserId(), notSeller1.getName()),
                new UserDTO(notSeller2.getUserId(), notSeller2.getName())
        );
    }

    public static User createFollower(){

        return new User(15,"test user",false);
    }
}
