package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;


public interface IFollowsService {
    ResFollowPostDTO follow(int userId, int userToFollowId);

    ResListFollowersDTO getListFollowers(int userId);

    /**
     *
     * @param userId numero entero para buscar al usuario
     * @return DTO de respuesta con toda la info requerida
     */
    ResCountFollowersDTO countFollowers(int userId);


}
