package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PromoPostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;

import java.util.List;

public interface IPostService {
    PostCreatedDTO createPost(PostCreateDTO postCreateDTO);
    ProductCreatedDTO createProduct(ProductCreateDTO productCreateDTO);
    List<ProductResponseDTO> getAllProducts();
    UserPostResponseDTO getAllPostsByFollowerId(int userId, String order);
    UserPromoPostResponseDTO getAllPromoPostsBySellerId(int userId, String order);
    List<PostResponseDTO> getAllPosts();
    PostCreatedDTO createPromoPost(PromoPostCreateDTO postCreateDTO);
}
