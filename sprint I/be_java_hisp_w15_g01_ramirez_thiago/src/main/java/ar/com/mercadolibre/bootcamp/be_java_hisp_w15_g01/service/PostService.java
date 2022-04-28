package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;

import java.time.LocalDate;

public interface PostService {

    ResponseDTO createPost(PostDTO postDto);

    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    PromotionProductsCountDTO howManyProductsPromoHave(Long userID);

    ResponseDTO createPostPromo(PromotionProductsDTO ProdPromoDTO);

    PostPromoListDTO getListPromoPost(Long userID);
}
