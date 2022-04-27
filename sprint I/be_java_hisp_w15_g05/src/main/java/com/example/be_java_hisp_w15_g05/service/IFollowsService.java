package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListSellersDTO;


public interface IFollowsService {
    ResFollowPostDTO follow(int userId, int userToFollowId);

    ResFollowPostDTO unFollow(int userId, int userToUnfollowId);

    ResListFollowersDTO getListFollowers(int userId);

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

    ResListSellersDTO getListSellers(int userId);

}
