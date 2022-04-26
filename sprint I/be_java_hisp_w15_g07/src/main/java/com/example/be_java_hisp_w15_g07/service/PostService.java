package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.repository.IPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    private IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
        ModelMapper modelMapper = new ModelMapper();
    }
}
