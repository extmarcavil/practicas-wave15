package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    /**
     * @id el id para buscar al usuario.
     * @return el usuario buscado o un opcional para arrojar una excepción.
     */
    Optional<User> findById(int id);

    /**
     *
     * @param usuario utilizado para seguir al vendedor.
     * @param vendedor utilizado para actualizar su lista de seguidores
     */
    void follow(User usuario, User vendedor);

    /**
     *
     * @param usuario utilizado para dejar de seguir al vendedor.
     * @param vendedor utilizado para actualizar su lista de seguidores.
     * @return un flag de si se ejecuto correctamente o no.
     */
    void unFollow(User usuario, User vendedor);

    /**
     *
     * @param id id del usuario
     * @return cantidad de followers de dicho usuario
     */
    int cantFollowers(User user);


    /**
     *
     * @param user usuario al cual se le asigna el posteo.
     * @param post el posteo a asignar.
     */

    void createPost(User user, Post post);

    /**
     *
     * @param id del usuario
     * @return lista de post del usuario solicitado
     */
    List<Post> getPostsById(int id);

}
