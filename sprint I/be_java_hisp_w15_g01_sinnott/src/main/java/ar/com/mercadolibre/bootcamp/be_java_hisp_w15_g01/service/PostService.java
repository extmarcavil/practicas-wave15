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
     * Crea un post en promocion
     *
     * @param postDto El post dto a crear
     * @return un ResponseDTO
     */
    ResponseDTO createPromoPost(PromoPostDTO postDto);

    /**
     * PostService
     * Actualiza un post
     *
     * @param postId El id del post a actualizar
     * @param postDTO la informacion a actualizar
     * @return un ResponseDTO
     */
    ResponseDTO updatePost(Long postId, PromoPostDTO postDTO);

    /**
     * PostService
     * Obtiene todos los posts de usuarios que siguen a userId
     *
     * @param userId El id del usuario a buscar
     * @param order El orden de los resultados
     * @return un PostListDTO
     */
    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    /**
     * PostService
     * Obtiene todos los posts en promocion de un vendedor
     *
     * @param userId El id del usuario a buscar
     * @return un PromoPostCountDTO
     */
    PromoPostCountDTO howManyPromoPostById(Long userId);

    /**
     * PostService
     * Obtiene todos los posts de un vendedor
     *
     * @param userId El id del usuario a buscar
     * @return un PostListDetailDTO
     */
    PostListDetailDTO getAllPostsByUserId(Long userId);



}
