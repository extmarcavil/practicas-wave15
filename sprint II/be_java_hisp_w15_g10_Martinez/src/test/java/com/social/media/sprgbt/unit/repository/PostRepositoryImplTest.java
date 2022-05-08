package com.social.media.sprgbt.unit.repository;

import com.social.media.sprgbt.entity.Follower;
import com.social.media.sprgbt.entity.Post;
import com.social.media.sprgbt.entity.Product;
import com.social.media.sprgbt.repository.IPostRepository;
import com.social.media.sprgbt.repository.impl.PostRepositoryImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {

    /**
     * Instancia de la clase a testear CategoryRepositoryImpl
     */
    private IPostRepository postRepositoryImpl;


    @BeforeEach
    void setUp() {
        postRepositoryImpl = new PostRepositoryImpl();
        PostRepositoryImpl.listOfPost = new ArrayList<>();
        PostRepositoryImpl.count = new AtomicInteger(0);
    }


    @Test
    @DisplayName("Test Create Post")
    void createPostTest() {
        //Arrange
        Post post1 = Data.POST_1;

        //Act
        Post result = postRepositoryImpl.createPost(post1);

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getPostId()),
                () -> assertEquals(post1.getUserId(), result.getUserId()),
                () -> assertEquals(post1.getProductId(), result.getProductId()),
                () -> assertEquals(post1.getCategoryId(), result.getCategoryId()),
                () -> assertEquals(post1.getDate(), result.getDate()),
                () -> assertEquals(post1.getPrice(), result.getPrice()),
                () -> assertEquals(post1.getHasPromo(), result.getHasPromo()),
                () -> assertEquals(post1.getDiscount(), result.getDiscount())
        );
    }


    @Test
    @DisplayName("Test Get Post By UserId With ProductId")
    void getPostByUserIdWithProductIdTest() {
        //Arrange
        Post post1 = Data.POST_1;
        Post post1_1 = Data.POST_1_1;
        Post postPromo = Data.POST_PROMO;
        Post post2 = Data.POST_2;

        postRepositoryImpl.createPost(post1);
        postRepositoryImpl.createPost(post1_1);
        postRepositoryImpl.createPost(postPromo);
        postRepositoryImpl.createPost(post2);

        //Act
        Post posts = postRepositoryImpl.getPostByUserIdWithProductId(1, 1);

        //Assert
        assertAll(

                () -> assertNotNull(posts),
                () -> assertEquals(1, posts.getPostId()),
                () -> assertEquals(post1.getUserId(), posts.getUserId()),
                () -> assertEquals(post1.getProductId(), posts.getProductId()),
                () -> assertEquals(post1.getCategoryId(), posts.getCategoryId()),
                () -> assertEquals(post1.getDate(), posts.getDate()),
                () -> assertEquals(post1.getHasPromo(), posts.getHasPromo()),
                () -> assertEquals(post1.getDiscount(), posts.getDiscount()),
                () -> assertEquals(post1.getPrice(), posts.getPrice())
        );
    }


    @Test
    @DisplayName("Test Get Post By UserId With ProductId Not Found")
    void getPostByUserIdWithProductIdNotFoundTest() {
        //Arrange

        //Act
        Post posts = postRepositoryImpl.getPostByUserIdWithProductId(5, 10);

        //Assert
        assertNull(posts);
    }

    @Test
    @DisplayName("Test Get Producto By id")
    void getProductByIdTest() {
        //Arrange
        Post post1 = Data.POST_1;
        Post post1_1 = Data.POST_1_1;
        Post postPromo = Data.POST_PROMO;
        Post post2 = Data.POST_2;

        postRepositoryImpl.createPost(post1);
        postRepositoryImpl.createPost(post1_1);
        postRepositoryImpl.createPost(postPromo);
        postRepositoryImpl.createPost(post2);

        //Act
        List<Post> posts = postRepositoryImpl.getAllPostByUser(2);

        //Assert
        assertAll(

                () -> assertNotNull(posts),
                () -> assertEquals(2, posts.size()),

                () -> assertEquals(2, posts.get(0).getPostId()),
                () -> assertEquals(3, posts.get(1).getPostId()),
                () -> assertEquals(post1_1.getUserId(), posts.get(0).getUserId()),
                () -> assertEquals(postPromo.getUserId(), posts.get(1).getUserId()),
                () -> assertEquals(post1_1.getProductId(), posts.get(0).getProductId()),
                () -> assertEquals(postPromo.getProductId(), posts.get(1).getProductId()),
                () -> assertEquals(post1_1.getCategoryId(), posts.get(0).getCategoryId()),
                () -> assertEquals(postPromo.getCategoryId(), posts.get(1).getCategoryId()),
                () -> assertEquals(post1_1.getDate(), posts.get(0).getDate()),
                () -> assertEquals(postPromo.getDate(), posts.get(1).getDate()),
                () -> assertEquals(post1_1.getPrice(), posts.get(0).getPrice()),
                () -> assertEquals(postPromo.getPrice(), posts.get(1).getPrice()),
                () -> assertEquals(post1_1.getHasPromo(), posts.get(0).getHasPromo()),
                () -> assertEquals(postPromo.getHasPromo(), posts.get(1).getHasPromo()),
                () -> assertEquals(post1_1.getDiscount(), posts.get(0).getDiscount()),
                () -> assertEquals(postPromo.getDiscount(), posts.get(1).getDiscount())

        );
    }


}