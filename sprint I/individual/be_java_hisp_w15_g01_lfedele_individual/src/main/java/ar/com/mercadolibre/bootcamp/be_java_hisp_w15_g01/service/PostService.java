package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;

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

    /**
     * ProductController
     * Crea una publicacion en promocion
     *
     * @param dto el dto de la publicacion a crear
     */
    ResponseDTO createPostPromo(PostPromoDTO dto);

    /**
     * ProductController
     * Obtiene la cantidad de productos en promocion de id
     *
     * @param id el dto de la publicacion a crear
     */
    PromoProductCountDTO getUserPromoPosts(Long id);
}
