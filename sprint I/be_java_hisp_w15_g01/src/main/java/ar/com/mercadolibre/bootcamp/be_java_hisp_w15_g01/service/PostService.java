package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostPromoCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostPromoDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;

import java.time.LocalDate;

public interface PostService {

    ResponseDTO createPost(PostDTO postDto);

    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    ResponseDTO createPromoPost(PostPromoDTO promoPostDTO);

    PostPromoCountDTO getPostsPromoByUser(Long userId);
}
