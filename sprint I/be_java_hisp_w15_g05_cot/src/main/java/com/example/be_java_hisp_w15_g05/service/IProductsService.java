package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.model.Post;

import java.util.List;

public interface IProductsService {

    ResCreatePostDTO createPost(PostDTO postDTO);
    ResPostListDTO getPostFollowed(int id, String order);
    ResPromoPostsDTO getCountPromoPosts(int userId);
    ResListPromoPostDTO getListPromoPosts(int userId);
}
