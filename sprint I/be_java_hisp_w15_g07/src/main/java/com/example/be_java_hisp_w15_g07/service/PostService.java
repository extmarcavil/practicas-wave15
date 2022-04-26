package com.example.be_java_hisp_w15_g07.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    private IPostService postService;

    public PostService(IPostService postService) {
        this.postService = postService;
        ModelMapper modelMapper = new ModelMapper();
    }
}
