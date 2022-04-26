package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.PostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;

import java.util.List;

public interface IProductService {

    void savePost(PostDTO postDto);

    List<Post> getPostsLastTwoWeekById(Integer id);
}
