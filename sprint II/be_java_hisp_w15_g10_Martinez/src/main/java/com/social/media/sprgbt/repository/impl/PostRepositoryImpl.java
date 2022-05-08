package com.social.media.sprgbt.repository.impl;

import com.social.media.sprgbt.entity.Post;
import com.social.media.sprgbt.repository.IPostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    public static AtomicInteger count = new AtomicInteger(0);

    /**
     * Lista de Post
     */
    public static List<Post> listOfPost;


    /**
     * Inyeccion de dependencia por Contructor.
     */
    public PostRepositoryImpl() {
        this.listOfPost = new ArrayList<>();
    }


    /**
     * Create Post
     *
     * @param post param
     * @return {@link Post} obj
     */
    @Override
    public Post createPost(Post post) {

        post.setPostId(count.incrementAndGet());
        //post.setDate(LocalDate.now());

        listOfPost.add(post);

        return post;
    }

    /**
     * getPostByUserIdWithProductId
     *
     * @param userId    param
     * @param productId param
     * @return Post
     */
    @Override
    public Post getPostByUserIdWithProductId(Integer userId, Integer productId) {

        Optional<Post> post = listOfPost.stream()
                .filter(p -> p.getUserId().equals(userId) && p.getProductId().equals(productId))
                .findFirst();

        return post.orElse(null);
    }

    /**
     * Get All Post By User
     *
     * @param userId param
     * @return {@link Post} list
     */
    @Override
    public List<Post> getAllPostByUser(Integer userId) {

        List<Post> listPostByUser = listOfPost.stream()
                .filter(obj -> obj.getUserId().equals(userId))
                .collect(Collectors.toList());

        return listPostByUser;
    }

}
