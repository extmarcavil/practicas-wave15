package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;

public interface IProductsService {

    ResCreatePostDTO createPost(PostDTO postDTO);
    ResCreatePostDTO createPromoPost(PromoPostDTO promoPostDTO);
    ResPostListDTO getPostFollowed(int id, String order);
    ResCountPromoPostDTO getCountPromoPosts(int userId);
}
