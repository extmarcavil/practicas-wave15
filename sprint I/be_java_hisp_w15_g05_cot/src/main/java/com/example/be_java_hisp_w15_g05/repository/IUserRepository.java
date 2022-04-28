package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    /**
     * Obtiene un usuario buscandolo por id
     *
     * @param userId id del usuario a buscar
     * @return devuelve el usuario buscado
     */
    Optional<User> findById(int userId);

    /**
     * Un usuario comienza a seguir a un vendedor
     *
     * @param usuario usuario que hara la accion de seguir
     * @param vendedor vendedor a seguir
     */
    void follow(User usuario, User vendedor);

    /**
     * Un usuario deja de seguir a un vendedor
     *
     * @param usuario usuario que hara la accion de dejar de seguir
     * @param vendedor vendedor a dejar de seguir
     */
    void unFollow(User usuario, User vendedor);

    /**
     * Obtiene la cantidad de seguidores de un usuario
     *
     * @param user usuario a consultar
     * @return cantidad de seguidores de un usuario
     */
    int countFollowers(User user);

    /**
     * Crea una publicacion
     *
     * @param user usuario que crea la publicacion
     * @param post publicacion
     */
    void createPost(User user, Post post);

    /**
     * Obtiene los post de las ultimas dos semanas del userId correspondiente
     *
     * @param userId id del usuario a buscar
     * @return lista de post que corresponden al userId
     */
    List<Post> getPostsTwoWeeks(int userId);

    /**
     * Obtiene los post en promoción del userId correspondiente
     *
     * @param userId id del usuario a buscar
     * @return lista de post con promocion que corresponden al userId
     */
    List<Post> getPromoPosts(int userId);

}
