package com.social.media.sprgbt.service.impl;

import com.social.media.sprgbt.dto.FollowerDto;
import com.social.media.sprgbt.dto.PostDto;
import com.social.media.sprgbt.entity.Post;
import com.social.media.sprgbt.mapper.PostMapper;
import com.social.media.sprgbt.repository.IPostRepository;
import com.social.media.sprgbt.service.IPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostServiceImpl implements IPostService {

    /**
     * Inyeccion de dependencias.
     */
    @Autowired
    private PostMapper postMapper;

    /**
     * Instancia de IRepository
     */
    private IPostRepository postRepository;

    /**
     * Inyeccion de dependencia por Contructor.
     *
     * @param postRepository
     */
    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Create Post
     *
     * @param postDto param
     * @return {@link PostDto} obj
     */
    @Override
    public PostDto createPost(PostDto postDto) {

        Post entity = postMapper.mapToEntity(postDto);

        Post newEntity = postRepository.createPost(entity);

        return postMapper.mapToDto(newEntity);
    }

    /**
     * getPostByUserIdWithProductId
     *
     * @param userId
     * @param productId
     * @return Post
     */
    @Override
    public PostDto getPostByUserIdWithProductId(Integer userId, Integer productId) {

        Post post = postRepository.getPostByUserIdWithProductId(userId, productId);

        return postMapper.mapToDto(post);
    }

    /**
     * Get All Post By User
     *
     * @param userId param
     * @return {@link PostDto} list
     */
    @Override
    public List<PostDto> getAllPostByUser(Integer userId) {

        List<Post> listPostByUser = postRepository.getAllPostByUser(userId);

        List<PostDto> listPostDtoByUser = listPostByUser.stream()
                .map(obj -> postMapper.mapToDto(obj))
                .collect(Collectors.toList());

        return listPostDtoByUser;
    }


}
