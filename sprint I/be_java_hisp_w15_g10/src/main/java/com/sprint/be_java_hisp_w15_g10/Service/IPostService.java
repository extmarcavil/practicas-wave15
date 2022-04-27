package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.PostCreatedDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.ProductResponseDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.VendedorsFollowedDTO;

import java.util.List;

public interface IPostService {
    PostCreatedDTO createPost(PostCreateDTO postCreateDTO);
    List<ProductResponseDTO> getAllProducts();
}
