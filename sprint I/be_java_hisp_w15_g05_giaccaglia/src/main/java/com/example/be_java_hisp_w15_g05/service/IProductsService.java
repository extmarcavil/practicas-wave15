package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;

import java.util.List;

public interface IProductsService {

    ResCreatePostDTO createPost(PostDTO postDTO);
    ResCreatePostDTO createPostPromo(PromoPostDTO promoPostDTO);
    ResPostListDTO getPostFollowed(int id, String order);
    ResPostCountDTO getPromoPostCount(int id);
    ResPostListDTO getPromoPostFollowed(int id);
}
