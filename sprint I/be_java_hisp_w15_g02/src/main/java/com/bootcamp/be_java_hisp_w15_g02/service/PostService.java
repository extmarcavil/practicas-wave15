package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.PostCreateDTO;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import org.springframework.stereotype.Service;
import java.time.ZoneId;

@Service
public class PostService implements IPostService{

    private IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public boolean createPost(PostCreateDTO newPost) {
        var id = 0;
        var postlist = postRepository.all();
        id = postlist.size() == 0 ? 1 : postlist.size() + 1 ;
        var modelProduct = new Product();
        var instant = newPost.getDate().toInstant();
        var zdt = instant.atZone(ZoneId.systemDefault());
        var date = zdt.toLocalDate();
        var modelPost = new Post(
                id, newPost.getUser_id(), date,Integer.valueOf(newPost.getCategory()),modelProduct,newPost.getPrice());
        postRepository.createPost(modelPost);
        return true;
    }
}
