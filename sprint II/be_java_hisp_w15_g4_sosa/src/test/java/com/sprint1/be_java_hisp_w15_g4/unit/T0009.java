package com.sprint1.be_java_hisp_w15_g4.unit;

import Utils.TestGenerator;
import com.sprint1.be_java_hisp_w15_g4.controller.ProductController;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.exception.AlreadyFollowing;
import com.sprint1.be_java_hisp_w15_g4.exception.IDNotFoundException;
import com.sprint1.be_java_hisp_w15_g4.model.Post;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint1.be_java_hisp_w15_g4.service.IProductService;
import com.sprint1.be_java_hisp_w15_g4.service.IUserService;
import com.sprint1.be_java_hisp_w15_g4.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class T0009 {
    @Mock
    private IUserRepository repo;

    @InjectMocks
    private ProductService product;

    @Test
    @DisplayName("Verificamos que la creacion del post sea correcta")
    void verifyNewPostOK() {
        // Arrange
        int userId1 = 1;
        User user1 = TestGenerator.GenerateUser(userId1,"nombre1");

        PostDTO postRequest = TestGenerator.GeneratePostsDTO(user1.getUser_id(),
                LocalDate.now().toString());
        Post post = TestGenerator.GeneratePosts(user1.getUser_id(),
                LocalDate.now().toString());
        // Mock
        Mockito.when(repo.findUser(userId1)).thenReturn(user1);
        // Act & Assert
        product.createPost(postRequest);
        Assertions.assertAll(
                () -> Assertions.assertEquals(user1.getPosts().size(), 1),
                () -> Assertions.assertEquals(post.getPrice(), user1.getPosts().get(0).getPrice()),
                () -> Assertions.assertEquals(post.getPost_id() + 1, user1.getPosts().get(0).getPost_id())
        );
    }



}
