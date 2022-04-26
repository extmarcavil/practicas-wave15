package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.User;

import java.util.List;

public interface IUserRepository {
    /**
     * @id el id para buscar al usuario
     */
    User findById(int id);
    boolean follow(int seguidor, int seguido);

    /**
     *
     * @param id id del usuario
     * @return cantidad de followers de dicho usuario
     */
    int cantFollowers(int id);
    List<User> followersList(int id);
}
