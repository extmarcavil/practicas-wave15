package com.sprint.be_java_hisp_w15_g10.unit.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Repository.CategoryRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.PostRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.ProductRepository;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


class PostRepositoryTest {

    PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = new PostRepository(new CategoryRepository(), new ProductRepository());
    }

    @Test
    void getPostById() {
        // arrange
        Post post1 = TestUtils.createPost(postRepository, LocalDate.of(2022, 4, 24));
        postRepository.add(post1);

        //act
        Optional<Post> oPost = postRepository.getById(post1.getPost_id());

        // assert
        Assertions.assertEquals(oPost.get().getDetail(), post1.getDetail());
        Assertions.assertEquals(oPost.get().getDate(), post1.getDate());
        Assertions.assertEquals(oPost.get().getCategory(), post1.getCategory());
        Assertions.assertEquals(oPost.get().getDiscount(), post1.getDiscount());
        Assertions.assertEquals(oPost.get().getPrice(), post1.getPrice());
        Assertions.assertEquals(oPost.get().isHas_promo(), post1.isHas_promo());
    }

    @Test
    void getInvalidUserById() {
        // arrange
        postRepository.add(TestUtils.createPost(postRepository, LocalDate.of(2022, 4, 24)));

        //act
        Optional<Post> oPost = postRepository.getById(10);

        // assert
        Assertions.assertTrue(oPost.isEmpty());
    }

    @Test
    void getAll() {
        // arrange
        postRepository.add(TestUtils.createPost(postRepository, LocalDate.of(2022, 4, 24)));
        postRepository.add(TestUtils.createPost(postRepository, LocalDate.of(2022, 4, 25)));
        postRepository.add(TestUtils.createPost(postRepository, LocalDate.of(2022, 4, 26)));

        //act
        List<Post> posts = postRepository.getAll();

        // assert
        Assertions.assertAll(
                () -> {
                    Assertions.assertFalse(posts.isEmpty());
                },
                () -> {
                    Assertions.assertEquals(posts.size(), 8);
                }
        );
    }

    @Test
    void add() {
        // arrange
        Post post = TestUtils.createPost(postRepository, LocalDate.of(2022, 4, 24));
        int initial_size = postRepository.getAll().size();
        // act
        postRepository.add(post);
        int final_size = postRepository.getAll().size();
        // assert
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(initial_size + 1, final_size);
                },
                () -> {
                    Assertions.assertEquals(post, postRepository.getById(post.getPost_id()).get());
                }
        );
    }
}