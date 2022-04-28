package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;

import java.util.List;

public interface IProductsService {

    ResCreatePostDTO createPost(PostDTO postDTO);
    ResCreatePostDTO createPostPromotion(PostPromotionDTO postPromotionDTO);
    ResPostListDTO getPostFollowed(int id, String order);
    ResCountProductsPromoDTO countProductsPromo(int userId);

    ResListPostPromoDTO listProductsPromo(Integer user_id);



}
