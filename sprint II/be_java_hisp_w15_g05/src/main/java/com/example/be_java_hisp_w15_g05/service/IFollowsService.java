package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListSellersDTO;


public interface IFollowsService {
    /**
     *
     * @param userId id del usuario el cual va a comenzar a seguir.
     * @param userToFollowId id del usuario el cual va a ser seguido.
     * @return DTO con la informacion solicitada.
     */
    ResFollowPostDTO follow(int userId, int userToFollowId);

    /**
     *
     * @param userId id del ususario a buscar los seguidores
     * @param order orden por el cual se ordenara la lista
     * @return DTO con la informacion solicitada
     */
    ResListFollowersDTO getListFollowers(int userId, String order);

    /**
     *
     * @param userId id del usuario el cual va a dejar de seguir.
     * @param userToUnfollowId id del usuario el cual va a dejar de ser seguido.
     * @return DTO con la informacion solicitada.
     */
    ResFollowPostDTO unFollow(int userId, int userToUnfollowId);

    /**
     *
     * @param userId numero entero para buscar al usuario
     * @return DTO de respuesta con toda la info requerida
     */
    ResCountFollowersDTO countFollowers(int userId);

    /**
     *
     * @param userId id del usuario
     * @return DTO de la lista de sellers
     */
    ResListSellersDTO getListSellers(int userId, String order);



}
