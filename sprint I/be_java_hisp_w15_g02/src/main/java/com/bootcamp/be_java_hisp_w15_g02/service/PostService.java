package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    private IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
