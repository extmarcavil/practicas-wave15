package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    public PostService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }

    public void newPost(NewPostDTO postDTO){
        Post post = modelMapper.map(postDTO, Post.class);
        userRepository.newPost(postDTO.getUserId(), post);
    }
}
