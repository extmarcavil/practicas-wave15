package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Override
    public void savePost(PostDTO postDto) {

    }

    @Override
    public List<Post> getPostsLastTwoWeekById(Integer id) {
        return null;
    }
}
