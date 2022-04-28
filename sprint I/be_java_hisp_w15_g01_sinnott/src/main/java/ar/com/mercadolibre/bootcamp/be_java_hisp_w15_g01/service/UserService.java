package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowedListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    /**
     * UserService
     * Accion de seguir a un vendedor
     *
     * @param userId El usuario que quiere seguir a otro usuario
     * @param userIdToFollow El usuario target al cual quieren seguir
     * @return Un ResponseDTO
     */
    ResponseDTO follow(Long userId, long userIdToFollow);

    /**
     * UserService
     * Busca un usuario por id
     *
     * @param id El id del usuario a buscar
     * @return Un User
     */
    User findById(Long id);


    /**
     * UserService
     * Devuelve la lista de quienes siguen a userId
     *
     * @param id El usuario a buscar
     * @param order El orden de los parametros
     * @return Un FollowersListDTO
     */
    FollowersListDTO whoFollowsMe(Long id, String order);

    /**
     * UserService
     * Devuelve la cuenta de cuantas personas siguen a userId
     *
     * @param userId El usuario a buscar
     * @return Un FollowersCountDTO
     */
    FollowersCountDTO howManyFollowsMe(Long userId);

    /**
     * UserService
     * Devuelve la la lista de todas las personas a las que sigue userId
     *
     * @param userId El usuario a buscar
     * @return Un FollowedListDTO
     */
    FollowedListDTO findAllFollowedByUserId(Long userId, String order);

    /**
     * UserController
     * Accion de dejar de seguir a un vendedor
     *
     * @param userId El usuario que quiere dejar de seguir a otro usuario
     * @param userIdToUnfollow El usuario target al cual quieren dejar de seguir
     * @return Un ResponseDTO
     */
    ResponseDTO unFollow(Long userId, long userIdToUnfollow);

}
