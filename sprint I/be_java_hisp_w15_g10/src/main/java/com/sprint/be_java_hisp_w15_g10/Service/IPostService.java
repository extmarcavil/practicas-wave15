package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.PostCreatedDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.PostResponseDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.ProductResponseDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserPostResponseDTO;

import java.util.List;

public interface IPostService {
    PostCreatedDTO createPost(PostCreateDTO postCreateDTO);
    List<ProductResponseDTO> getAllProducts();
    UserPostResponseDTO getAllPostsByFollowerId(int userId);
    List<PostResponseDTO> getAllPosts();
}
