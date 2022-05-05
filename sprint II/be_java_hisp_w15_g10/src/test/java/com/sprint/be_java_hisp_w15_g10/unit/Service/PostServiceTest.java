package com.sprint.be_java_hisp_w15_g10.unit.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductRequestDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.PostCreatedDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.PostResponseDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserPostResponseDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.Exception.CategoryNotFoundPostException;
import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundPostException;
import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.CategoryRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.PostRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.ProductRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import com.sprint.be_java_hisp_w15_g10.Service.PostService;
import com.sprint.be_java_hisp_w15_g10.Service.UserService;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    ModelMapper modelMapper;
    @Mock
    CategoryRepository categoryRepository;
    @Mock
    PostRepository postRepository;
    @Mock
    ProductRepository productRepository;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    PostService postServiceMock;

    private Category category1;
    private Product product1;
    private Post post1;
    private User user;
    private PostCreateDTO postCreateDTO;

    @BeforeEach
    void setup(){
        category1 = new Category(1, "categoria");
        product1 = new Product(1, "Pantalón", "Old", "Jeff", "Rojo", "");
        post1 = new Post(1, product1, LocalDate.now(), category1, 0.9, false, 0);
        user = TestUtils.createUser(4, "Luis");
        postCreateDTO = new PostCreateDTO();
        postCreateDTO.setCategory_id(1);
        postCreateDTO.setDate(LocalDate.now());
        postCreateDTO.setUser_id(4);
        postCreateDTO.setPrice(1D);
        postCreateDTO.setDetail(new ProductRequestDTO(1, "Pantalón", "Old", "Jeff", "Rojo", ""));
    }

    @Test
    void createPost() {

        doReturn(Optional.of(category1))
                .when(categoryRepository)
                .getById(anyInt());

        when(modelMapper
                .map(postCreateDTO, Post.class))
                .thenReturn(post1);

        when(userRepository
                .getById(anyInt()))
                .thenReturn(Optional.of(user));

        doReturn(Optional.of(product1))
                .when(productRepository)
                        .getById(anyInt());

        String message = postServiceMock.createPost(postCreateDTO).getMessage();

        Assertions.assertAll(
                () -> verify(categoryRepository, atLeastOnce()).getById(anyInt()),
                () -> verify(userRepository, atLeastOnce()).getById(anyInt()),
                () -> verify(productRepository, atLeastOnce()).getById(anyInt()),
                () -> Assertions.assertEquals("Se ha creado el Post con éxito", message)
        );



    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getAllPostsByFollowerId() {
        // arrange
        TestUtils.addFollowed(user, 4);
        List<Post> validPosts = TestUtils.addFollowedPosts(user);
        when(userRepository.getById(4)).thenReturn(Optional.of(user));
        // act
        List<PostResponseDTO> postResponseDTOS = validPosts.stream()
                .map(post -> modelMapper.map(post, PostResponseDTO.class))
                .collect(Collectors.toList());
        List<PostResponseDTO> postResponseDTOS1 = postServiceMock.getAllPostsByFollowerId(4, "asc")
                .getPosts();

        // assert
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(postResponseDTOS, postResponseDTOS1);
                }
        );

    }
}