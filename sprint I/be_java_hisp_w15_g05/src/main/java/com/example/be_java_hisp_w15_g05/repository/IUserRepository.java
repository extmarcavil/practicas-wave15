package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.User;

import java.util.Optional;

public interface IUserRepository {
    /**
     * @id el id para buscar al usuario
     * @return
     */
    Optional<User> findById(int id);
    boolean follow(User usuario, User vendedor);

    boolean unFollow(User usuario, User vendedor);

    /**
     *
     * @param id id del usuario
     * @return cantidad de followers de dicho usuario
     */
    int cantFollowers(User user);

    Optional<User> followersList(int id);


    void createPost(User user, Post post);

    /**
     *
     * @param id del usuario
     * @return devuelve una lista de vendedores
     */
    Optional<User> sellersList(int id);

}
