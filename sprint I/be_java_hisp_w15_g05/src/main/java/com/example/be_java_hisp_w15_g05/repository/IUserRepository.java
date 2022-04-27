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
     * @return un flag de si se ejecuto correctamente o no.
     */
    boolean follow(User usuario, User vendedor);

    /**
     *
     * @param usuario utilizado para dejar de seguir al vendedor.
     * @param vendedor utilizado para actualizar su lista de seguidores.
     * @return un flag de si se ejecuto correctamente o no.
     */
    boolean unFollow(User usuario, User vendedor);

    /**
     *
     * @param id id del usuario
     * @return cantidad de followers de dicho usuario
     */
    int cantFollowers(User user);

    /**
     *
     * @param id del usuario al cual se solicita la lista de seguidores.
     * @return un opcional que devulve la lista de seguidores.
     */
    Optional<User> followersList(int id);

    /**
     *
     * @param user usuario al cual se le asigna el posteo.
     * @param post el posteo a asignar.
     */

    void createPost(User user, Post post);

    /**
     *
     * @param id del usuario
     * @return devuelve una lista de vendedores
     */
    Optional<User> sellersList(int id);

    /**
     *
     * @param id del usuario
     * @return lista de post del usuario solicitado
     */
    List<Post> getPostsTwoWeeks(int id);

}
