package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;

public interface PostService {

    ResponseDTO createPost(PostDTO postDto);

    ResponseDTO createPromoPost(PromoPostDTO postDto);

    ResponseDTO updatePost(Long postId, PromoPostDTO postDTO);

    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    PromoPostCountDTO howManyPromoPostById(Long userId);

    PostListDetailDTO getAllPostsByUserId(Long userId);



}
