package com.sprint.be_java_hisp_w15_g10.unit.Controller;

import com.sprint.be_java_hisp_w15_g10.Controller.PostController;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class PostControllerTest {
    @Mock
    PostService postService;
    @InjectMocks
    PostController postController;

    @Test
    void createPost() {
        // arrange
        PostCreatedDTO userWithFollowersCountDTO = new PostCreatedDTO();
        Mockito.when(postService.createPost(Mockito.any())).thenReturn(userWithFollowersCountDTO);
        // act
        ResponseEntity<PostCreatedDTO> response = postController.createPost(new PostCreateDTO());
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(postService, Mockito.times(1)).createPost(Mockito.any());},
                ()->{Assertions.assertEquals(userWithFollowersCountDTO, response.getBody());}
        );
    }

    @Test
    void getProducts() {
        // arrange
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        Mockito.when(postService.getAllProducts()).thenReturn(productResponseDTOS);
        // act
        ResponseEntity<List<ProductResponseDTO>> response = postController.getProducts();
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(postService, Mockito.times(1)).getAllProducts();},
                ()->{Assertions.assertEquals(productResponseDTOS, response.getBody());}
        );
    }

    @Test
    void getAllPostsByFollowerId() {
        // arrange
        UserPostResponseDTO userPostResponseDTO = new UserPostResponseDTO();
        Mockito.when(postService.getAllPostsByFollowerId(Mockito.anyInt(), Mockito.anyString())).thenReturn(userPostResponseDTO);
        // act
        ResponseEntity<UserPostResponseDTO> response = postController.getAllPostsByFollowerId(1, "date_asc");
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(postService, Mockito.times(1)).getAllPostsByFollowerId(Mockito.anyInt(), Mockito.anyString());},
                ()->{Assertions.assertEquals(userPostResponseDTO, response.getBody());}
        );
    }

    @Test
    void getAllPosts() {
        // arrange
        List<PostResponseDTO> postResponseDTOS = new ArrayList<>();
        Mockito.when(postService.getAllPosts()).thenReturn(postResponseDTOS);
        // act
        ResponseEntity<List<PostResponseDTO>> response = postController.getAllPosts();
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);},
                ()->{Mockito.verify(postService, Mockito.times(1)).getAllPosts();},
                ()->{Assertions.assertEquals(postResponseDTOS, response.getBody());}
        );
    }
}