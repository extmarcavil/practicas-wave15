package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;

public interface IPostService {
    boolean createPost(PostCreateDTO newPost);
}
