package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<ResFollowPostDTO> follow(int userId, int userToFollowId);

    /**
     *
     * @param userId numero entero para buscar al usuario
     * @return DTO de respuesta con toda la info requerida
     */
    ResCountFollowersDTO countFollowers(int userId);
}
