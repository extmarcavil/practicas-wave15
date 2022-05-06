package com.example.be_java_hisp_w15_g07.unit.controller;

import com.example.be_java_hisp_w15_g07.controller.PostController;
import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.PostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.service.IPostService;
import com.example.be_java_hisp_w15_g07.utils.PostFactory;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Mock
    IPostService service;

    @InjectMocks
    PostController controller;
  
    @Test
    @DisplayName("T0005 - Verificar que el tipo de ordenamiento por fecha ascendente existe")
    public void getUserFollowedPostAscExists(){
        // Arrange
        Integer userId = 1;
        String order = "date_asc";

        // Mock
        Mockito.when(service.getFollowedPosts(userId, order)).thenReturn(UserFactory.getUserOneFollowedDTOAsc());

        // Act
        ResponseEntity<UserFollowedPostsDTO> result = controller.getUserFollowedPosts(userId, order);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0005 - Verificar que el tipo de ordenamiento por fecha descendente existe")
    public void getUserFollowedPostDescExists(){
        // Arrange
        Integer userId = 1;
        String order = "date_desc";

        // Mocks
        Mockito.when(service.getFollowedPosts(userId, order)).thenReturn(UserFactory.getUserOneFollowedDTODesc());

        // Act
        ResponseEntity<UserFollowedPostsDTO> result = controller.getUserFollowedPosts(userId, order);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0005 - Verificar que se lanza una excepcion cuando el tipo de ordenamiento no existe")
    public void getUserFollowedPostBadRequest(){
        // Arrange
        Integer userId = 1;
        String order = "Otro ordenamiento";

        // Mock
        when(service.getFollowedPosts(userId, order)).thenThrow(BadRequestException.class);

        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> controller.getUserFollowedPosts(userId, order));
    }

    @Test
    @DisplayName("T0006 - Verificar el correcto ordenamiento ascendente por fecha")
    public void getUserFollowedPostAsc(){
        // Arrange
        Integer userId = 1;
        String order = "date_asc";
        ResponseEntity<UserFollowedPostsDTO> expected = new ResponseEntity<>(UserFactory.getUserOneFollowedDTOAsc(),
                HttpStatus.OK);
        UserFollowedPostsDTO expectedBody = UserFactory.getUserOneFollowedDTOAsc();

        // Mocks
        Mockito.when(service.getFollowedPosts(userId, order)).thenReturn(UserFactory.getUserOneFollowedDTOAsc());

        // Act
        ResponseEntity<UserFollowedPostsDTO> result = controller.getUserFollowedPosts(userId, order);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> Assertions.assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0006 - Verificar el correcto ordenamiento descendente por fecha")
    public void getUserFollowedPostDesc(){
        // Arrange
        Integer userId = 1;
        String order = "date_desc";
        ResponseEntity<UserFollowedPostsDTO> expected = new ResponseEntity<>(UserFactory.getUserOneFollowedDTODesc(),
                HttpStatus.OK);
        UserFollowedPostsDTO expectedBody = UserFactory.getUserOneFollowedDTODesc();

        // Mock
        Mockito.when(service.getFollowedPosts(userId, order)).thenReturn(UserFactory.getUserOneFollowedDTODesc());

        // Act
        ResponseEntity<UserFollowedPostsDTO> result = controller.getUserFollowedPosts(userId, order);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> Assertions.assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0008 - Verificar el correcto filtro de publicaciones recientes de los usuarios seguidos")
    public void returnRecentPostsUsersFollowed(){
        // Arrange
        Integer userId = 1;
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        // Mock
        when(service.getFollowedPosts(userId, "date_asc")).thenReturn(new UserFollowedPostsDTO(1, PostFactory.getPostsDTO()));

        // Act
        ResponseEntity<UserFollowedPostsDTO> result = controller.getUserFollowedPosts(1, "date_asc");

        // Assert
        assertAll(
                () -> assertEquals(HttpStatus.OK, result.getStatusCode()),
                () -> assertEquals(PostFactory.getPostsDTO().size(), result.getBody().getPosts().size())
        );
        for (PostDTO postDTO: result.getBody().getPosts()) {
            assertTrue(postDTO.getDate().isAfter(twoWeeksAgo));
        }
    }

    @Test
    @DisplayName("BONUS - Verificar que se crea un nuevo post correctamente")
    public void createNewPostSuccess(){
        // Arrange
        NewPostDTO post = PostFactory.getNewPostDTO();

        // Mock
        doNothing().when(service).newPost(post);

        // Act
        ResponseEntity<?> result = controller.newPost(post);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
