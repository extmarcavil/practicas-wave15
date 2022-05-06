package com.sprint.be_java_hisp_w15_g10.unit.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductRequestDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.PostResponseDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.ProductResponseDTO;
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
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
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
    private Product product2;
    private Post post1;
    private Post post2;
    private User user;
    private PostCreateDTO postCreateDTO;
    public ProductRequestDTO productRequestDTO;

    @BeforeEach
    void setup() {
        category1 = TestUtils.createCategory();
        product1 = TestUtils.createProduct();
        product2 = TestUtils.createProduct2();
        post1 = TestUtils.createPost(postRepository, LocalDate.now());
        post2 = TestUtils.createPost2(postRepository, LocalDate.now());
        user = TestUtils.createUser(4, "Luis");
        productRequestDTO = TestUtils.createProductRequestDTO();
        postCreateDTO = TestUtils.createPostCreateDTO(productRequestDTO);


    }


    /**
     * Valida que se pueda crear un post
     */

    @Test
    @DisplayName("Test creacion de un post")
    void createPostTest() {
        //Arrange
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

        //Act
        String message = postServiceMock.createPost(postCreateDTO).getMessage();

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals("Se ha creado el Post con éxito", message),
                () -> Assertions.assertEquals(4, category1.getCategory_id()),
                () -> Assertions.assertEquals("Tecnología", category1.getCategory_name()),
                () -> Assertions.assertEquals("Tecnología", category1.getCategory_name()),
                () -> Assertions.assertEquals(1, postCreateDTO.getCategory_id()),
                () -> Assertions.assertEquals(LocalDate.now(), postCreateDTO.getDate()),
                () -> Assertions.assertEquals(4, postCreateDTO.getUser_id()),
                () -> Assertions.assertEquals(1D, postCreateDTO.getPrice()),
                () -> Assertions.assertEquals(productRequestDTO, postCreateDTO.getDetail()),
                () -> Assertions.assertEquals(1, productRequestDTO.getProduct_id()),
                () -> Assertions.assertEquals("Pantalón", productRequestDTO.getProduct_name()),
                () -> Assertions.assertEquals("Old", productRequestDTO.getType()),
                () -> Assertions.assertEquals("Jeff", productRequestDTO.getBrand()),
                () -> Assertions.assertEquals("Rojo", productRequestDTO.getColor()),
                () -> Assertions.assertEquals("", productRequestDTO.getNotes()),
                () -> verify(categoryRepository, atLeastOnce()).getById(anyInt()),
                () -> verify(userRepository, atLeastOnce()).getById(anyInt()),
                () -> verify(productRepository, atLeastOnce()).getById(anyInt())
        );

    }

    /**
     * Valida que se cree un producto si se envía un ID producto nuevo
     */

    @Test
    @DisplayName("Test creación de producto")
    void createPostVoidProductTest() {

        //Arrange
        doReturn(Optional.of(category1))
                .when(categoryRepository)
                .getById(anyInt());

        when(modelMapper
                .map(postCreateDTO, Post.class))
                .thenReturn(post1);

        when(userRepository
                .getById(anyInt()))
                .thenReturn(Optional.of(user));

        doReturn(Optional.empty())
                .when(productRepository)
                .getById(anyInt());

        postServiceMock.createPost(postCreateDTO).getMessage();

        Assertions.assertAll(
                () -> verify(productRepository, atLeastOnce()).add(any(Product.class))
        );
    }

    /**
     * valida que se pueda lanzar una Excepcion cuando la categoría no existe
     */
    @Test
    @DisplayName("Test de lanzamiento de excepcion cuando la categoria no existe")
    void createPostThrowsExceptionCategoryNotFoundTest() {
        //Arrange

        //Act & Assert
        Assertions.assertAll(
                () -> assertThrows(CategoryNotFoundPostException.class, () -> postServiceMock.createPost(postCreateDTO)),
                () -> verify(categoryRepository).getById(anyInt())
        );

    }

    /**
     * Valida que se pueda lanzar una Excepcion cuando el usuario no existe
     */
    @Test
    @DisplayName("Test excepcion cuando el usuario no existe")
    void createPostThrowsExceptionUserNotFoundTest() {
        //Arrange
        doReturn(Optional.of(category1))
                .when(categoryRepository)
                .getById(anyInt());

        when(modelMapper
                .map(postCreateDTO, Post.class))
                .thenReturn(post1);
        //Act & Assert
        Assertions.assertAll(
                () -> assertThrows(UserNotFoundPostException.class, () -> postServiceMock.createPost(postCreateDTO)),
                () -> verify(categoryRepository).getById(anyInt())
        );

    }

    /**
     * Valida que se puedan traer todos los productos
     */
    @Test
    @DisplayName("Test obtener todos los productos")
    void getAllProducts() {
        //Arrange
        ProductResponseDTO prdTo = new ProductResponseDTO();
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        when(productRepository.getAll()).thenReturn(products);
        when(modelMapper.map(product1, ProductResponseDTO.class)).thenReturn(prdTo);

        //Act
        List<ProductResponseDTO> list = postServiceMock.getAllProducts();
        //Assert
        Assertions.assertAll(
                () -> assertFalse(list.isEmpty()),
                () -> assertNotNull(list),
                () -> assertEquals(2, list.size()),
                () -> verify(productRepository).getAll(),
                () -> verify(modelMapper, times(1)).map(product1, ProductResponseDTO.class)
        );
    }

    /**
     * Valida que se puedan traer todos los productos con menor fecha dentro de dos semanas
     */
    @Test
    @DisplayName("Test obtener todos los productos con menor fecha dentro de dos semanas")
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

    /**
     * valida que pueda traer todos los posts
     */
    @Test
    @DisplayName("Test obtener todos los post")
    void getAllPost() {
        //Arrange
        PostResponseDTO prDTO = new PostResponseDTO();
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);

        when(postRepository.getAll()).thenReturn(posts);
        when(modelMapper.map(post1, PostResponseDTO.class)).thenReturn(prDTO);

        //Act
        List<PostResponseDTO> list = postServiceMock.getAllPosts();

        //Assert
        Assertions.assertAll(
                () -> assertFalse(list.isEmpty()),
                () -> assertNotNull(list),
                () -> assertEquals(2, list.size()),
                () -> verify(postRepository).getAll(),
                () -> verify(modelMapper, times(1)).map(post1, PostResponseDTO.class)
        );
    }
}