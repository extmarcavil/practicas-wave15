package com.example.be_java_hisp_w15_g05.utils;

import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListSellersDTO;
import com.example.be_java_hisp_w15_g05.dto.UserDTO;
import com.example.be_java_hisp_w15_g05.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersFactory {
    private static User user1 = new User(10, "Juan", false);
    private static User user2 = new User(11, "APedro", false);
    private static User user3 = new User(12, "Valentina", false);

    public static User createUserWithFollowers(){
        User user = new User(90,"test user",true);

        user.agregarSeguidor(user1);
        user.agregarSeguidor(user2);
        user.agregarSeguidor(user3);

        return user;
    }

    public static User createUserWithFolloweds(){
        User user = new User(90,"test user",true);

        user.seguir(user1);
        user.seguir(user2);
        user.seguir(user3);

        return user;
    }

    public static User createUserWithFollowed() {
        User user = new User(90,"test user",true);

        user.seguir(user1);

        return user;
    }

    public static List<UserDTO> listaOrdenadaAlfAsc(){
        return Arrays.asList(
                new UserDTO(user2.getUserId(), user2.getName()),
                new UserDTO(user1.getUserId(), user1.getName()),
                new UserDTO(user3.getUserId(), user3.getName())
        );
    }

    public static List<UserDTO> listaOrdenadaAlfDesc(){
        return Arrays.asList(
                new UserDTO(user3.getUserId(), user3.getName()),
                new UserDTO(user1.getUserId(), user1.getName()),
                new UserDTO(user2.getUserId(), user2.getName())
        );
    }

    public static User createFollower(){
        return new User(15,"test user",false);
    }

    public static ResListFollowersDTO getListFollowers() {
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(10, "Juan"));

        return new ResListFollowersDTO(2, "Antonio", users);
    }

    public static ResListSellersDTO getListFollowed() {
        List<UserDTO> users = new ArrayList<>();
        return new ResListSellersDTO(2, "Antonio", users);
    }

}
