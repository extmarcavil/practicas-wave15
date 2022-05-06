package com.social.media.sprgbt.repository;

import com.social.media.sprgbt.entity.Post;

import java.util.List;

public interface IPostRepository {

    /**
     * Create Post
     *
     * @param post param
     * @return {@link Post} obj
     */
    Post createPost(Post post);

    /**
     * getPostByUserIdWithProductId
     *
     * @param userId    param
     * @param productId param
     * @return Post
     */
    Post getPostByUserIdWithProductId(Integer userId, Integer productId);


    /**
     * Get All Post By User
     * @param userId param
     * @return {@link Post} list
     */
    List<Post> getAllPostByUser(Integer userId);

}
