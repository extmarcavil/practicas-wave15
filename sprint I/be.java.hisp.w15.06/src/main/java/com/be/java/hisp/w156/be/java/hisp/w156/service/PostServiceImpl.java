package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService {

    private IPostRepository repository;

    @Autowired
    public PostServiceImpl(IPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDTO createPost(PostDTO post){
       repository.save( Post.from(post));
       return post;
    }


}
