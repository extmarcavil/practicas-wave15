package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;

import java.time.LocalDate;

public interface PostService {

    /**
     * PostService
     * Crea un post
     *
     * @param postDto El post dto a crear
     * @return un ResponseDTO
     */
    ResponseDTO createPost(PostDTO postDto);

    /**
     * PostService
     * Obtiene todos los posts de usuarios que siguen a userId
     *
     * @param userId El id del usuario a buscar
     * @param order El orden de los resultados
     */
    PostListDTO getPostsByFollowedUsers(Long userId, String order);
}
