package com.example.be_java_hisp_w15_g05.unit.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.OrderNotValidException;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import com.example.be_java_hisp_w15_g05.service.ProductsService;
import com.example.be_java_hisp_w15_g05.utils.PostFactory;
import com.example.be_java_hisp_w15_g05.utils.UsersFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductsServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    ProductsService productsService;

    // T005 - T006
    @Test
    @DisplayName("Verificación de fecha ascendiente")
    void verificarCorrectoOrdenAscFecha() {
        //arrange
        User user = UsersFactory.createUserWithFollowed();
        List<PostIdDTO> postsOrdenados = PostFactory.getListPostsAsc();

        //act
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userRepository.getPostsById(10)).thenReturn(PostFactory.getListPosts());
        ResPostListDTO resp = productsService.getPostFollowed(1, "date_asc");

        // assert
        Assertions.assertEquals(postsOrdenados, resp.getPosts());
    }

    @Test
    @DisplayName("Verificación de fecha descendente")
    void verificarCorrectoOrdenDescFecha() {
        //arrange
        User user = UsersFactory.createUserWithFollowed();
        List<PostIdDTO> postsOrdenados = PostFactory.getListPostsDesc();

        //act
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userRepository.getPostsById(10)).thenReturn(PostFactory.getListPosts());
        ResPostListDTO resp = productsService.getPostFollowed(1, "date_desc");

        // assert
        Assertions.assertEquals(postsOrdenados, resp.getPosts());
    }

    @Test
    @DisplayName("Verificación de fecha default")
    void verificarCorrectoOrdenDefaultFecha() {
        //arrange
        User user = UsersFactory.createUserWithFollowed();
        List<PostIdDTO> postsOrdenados = PostFactory.getListPostsAsc();

        //act
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userRepository.getPostsById(10)).thenReturn(PostFactory.getListPosts());
        ResPostListDTO resp = productsService.getPostFollowed(1, "");

        // assert
        Assertions.assertEquals(postsOrdenados, resp.getPosts());
    }

    @Test
    @DisplayName("Verificacion lanzado de excepcion OrderNotValidException")
    void verificarExcepcionOrdenFecha() {
        Assertions.assertThrows(
                OrderNotValidException.class,
                () -> productsService.getPostFollowed(1, "cualquierorden"));
    }

    // T008
    @Test
    @DisplayName("Verificación correcto filtro de fecha")
    void verificarCorrectoFiltroPorFecha() {
        //arrange
        User user = UsersFactory.createUserWithFollowed();
        List<PostIdDTO> postsOrdenados = PostFactory.getListPostsAsc();

        //act
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userRepository.getPostsById(10)).thenReturn(PostFactory.getPostsOutOfDate());
        ResPostListDTO resp = productsService.getPostFollowed(1, "");

        // assert
        Assertions.assertEquals(postsOrdenados, resp.getPosts());
    }
}
