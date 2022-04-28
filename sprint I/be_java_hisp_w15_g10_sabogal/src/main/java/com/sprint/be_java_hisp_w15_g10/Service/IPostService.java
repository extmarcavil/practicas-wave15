package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostPromoDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;

import javax.validation.Valid;
import java.util.List;

public interface IPostService {
    PostCreatedDTO createPost(@Valid PostCreateDTO postCreateDTO);
    List<ProductResponseDTO> getAllProducts();
    UserPostResponseDTO getAllPostsByFollowerId(int userId, String order);
    List<PostResponseDTO> getAllPosts();

    PostsPromoDTO createPromoPost(@Valid PostPromoDTO postPromoDTO);


    //PostsPromoDTO getCountPromoPost(User)
    List<PostResponseDTO> getAllPromoPosts();

    VendorProductsDTO countPromoProductOfVendor(int userId);


}
