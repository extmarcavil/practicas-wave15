package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService {

    private final IPostRepository repository;

    @Autowired
    public PostServiceImpl(IPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public RequestPostDTO createPost(RequestPostDTO post){
       repository.save(Post.from(post));
       return post;
    }


}
