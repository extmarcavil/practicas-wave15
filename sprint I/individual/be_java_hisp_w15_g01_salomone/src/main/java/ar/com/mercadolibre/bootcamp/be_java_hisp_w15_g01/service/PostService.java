package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PostService {

    ResponseDTO createPost(PostDTO postDto);

    ResponseDTO createPromoPost(PromoPostDTO postDto);

    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    CountDTO countPromoPost(Long userId);

    PromoPostListDTO allPromoProducts(Long userId);

   Product findProductById(Long id);

    ResponseDTO addProductToPurchase(Long userId, Long productId);

    List<Product> showAllProductsOfPurchase(Long userId);


}
