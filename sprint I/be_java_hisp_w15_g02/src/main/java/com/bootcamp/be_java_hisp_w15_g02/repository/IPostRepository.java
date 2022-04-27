package com.bootcamp.be_java_hisp_w15_g02.repository;

import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import java.util.List;

public interface IPostRepository {
    void createPost(Post newPost);
    Post findPostById(int postId);
    List<Post> postsByUser(int userId);
}
