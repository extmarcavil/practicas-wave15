package com.bootcamp.be_java_hisp_w15_g02.unit.repository;

import com.bootcamp.be_java_hisp_w15_g02.exception.PostNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import com.bootcamp.be_java_hisp_w15_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.PostRepository;
import com.bootcamp.be_java_hisp_w15_g02.unit.utils.Global;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostRepositoryTest {

    private IPostRepository postRepository;

    @BeforeEach
    public void setup() {
        postRepository = new PostRepository();
    }

    @Test
    @DisplayName("Successfull post creation")
    public void createPostTest() {
        // arrange
        Post post = new Post();
        int sizeExpected = postRepository.all().size() + 1;

        // act
        postRepository.createPost(post);

        // assert
        assertThat(postRepository.all().size()).isEqualTo(sizeExpected);
    }

    @Test
    @DisplayName("Search post by existing id")
    public void searchPostByIdValid() {
        // arrange
        int validId = 2;
        Post expectedPost = new Post(validId,4, LocalDate.parse("2022-04-25"),2,
                                new Product(2,"iphone 12","electronic","apple","rose gold",
                                            "iphone 64 GB"),10000);
        // act
        Post postResult = postRepository.findPostById(validId);

        // assert
        assertThat(expectedPost).usingRecursiveComparison().isEqualTo(expectedPost);
    }

    @Test
    @DisplayName("Search for posts by existing user")
    public void searchPostsByUser() {
        // arrange
        int validId = 5;
        List<Post> expectedPosts = Global.getPosts();

        // act
        List<Post> resultPosts = postRepository.postsByUser(validId);

        // assert
        assertThat(resultPosts).usingRecursiveComparison().isEqualTo(expectedPosts);
    }

    @Test
    @DisplayName("Search for posts by invalid user")
    public void searchPostsByInvalidUser() {
        // arrange
        int validId = 500;
        List<Post> expectedPosts = Global.getPosts();

        // act & assert
        Assertions.assertThrows(PostNotFoundException.class, () -> postRepository.postsByUser(validId));
    }
}
