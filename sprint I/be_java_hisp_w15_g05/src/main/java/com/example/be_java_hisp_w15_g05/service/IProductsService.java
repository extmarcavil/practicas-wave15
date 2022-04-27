package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResCreatePostDTO;

public interface IProductsService {

    ResCreatePostDTO createPost(PostDTO postDTO);
}
