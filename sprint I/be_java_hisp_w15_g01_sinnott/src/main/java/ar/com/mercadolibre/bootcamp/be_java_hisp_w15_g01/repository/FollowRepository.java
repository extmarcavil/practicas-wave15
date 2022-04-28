package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.util.List;

public interface FollowRepository {

    /**
     * FollowRepository
     * Crea un objeto Follow en donde follower sigue a following
     *
     * @param follower El usuario que sigue
     * @param following El usuario que es seguido
     * @return Un Follow
     */
    Follow save(User follower, User following);

    /**
     * FollowRepository
     * Dice si follower sigue a followed
     *
     * @param follower El usuario que sigue
     * @param followed El usuario que es seguido
     * @return Si follower sigue a followed
     */
    Boolean existByFollowerAndFollowed(User follower, User followed);

    /**
     * FollowRepository
     * Devuelve una lista de todas las follows en donde el seguido tiene id id
     *
     * @param id El usuario a buscar
     * @return Una lista de follows
     */
    List<Follow> whoFollows(Long id);


    /**
     * FollowRepository
     * Devuelve una lista de todas las follows en donde el seguidor tiene id id
     *
     * @param id El usuario a buscar
     * @return Una lista de User
     */
    List<User> findFollowedByUserId(Long id);

    /**
     * FollowRepository
     * Quita un objeto Follow en donde follower sigue a following
     *
     * @param follower El usuario que sigue
     * @param following El usuario que es seguido
     * @return void
     */
    void unFollow(User follower, User following);
}
