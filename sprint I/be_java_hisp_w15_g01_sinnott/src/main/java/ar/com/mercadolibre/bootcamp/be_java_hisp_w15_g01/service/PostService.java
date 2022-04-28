package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;

import java.time.LocalDate;

public interface PostService {

    ResponseDTO createPost(PostDTO postDto);

    ResponseDTO createPromoPost(PromoPostDTO postDto);

    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    PromoPostCountDTO howManyPromoPostById(Long userId);
}
