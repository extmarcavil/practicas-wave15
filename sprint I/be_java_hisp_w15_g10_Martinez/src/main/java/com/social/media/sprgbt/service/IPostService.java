package com.social.media.sprgbt.service;

import com.social.media.sprgbt.dto.PostDto;
import com.social.media.sprgbt.entity.Post;

import java.util.List;

public interface IPostService {

    /**
     * Create Post
     *
     * @param postDto param
     * @return {@link Post} obj
     */
    PostDto createPost(PostDto postDto);

    /**
     * getPostByUserIdWithProductId
     *
     * @param userId
     * @param productId
     * @return Post
     */
    PostDto getPostByUserIdWithProductId(Integer userId, Integer productId);

    /**
     * Get All Post By User
     * @param userId param
     * @return {@link PostDto} list
     */
    List<PostDto> getAllPostByUser(Integer userId);

}
