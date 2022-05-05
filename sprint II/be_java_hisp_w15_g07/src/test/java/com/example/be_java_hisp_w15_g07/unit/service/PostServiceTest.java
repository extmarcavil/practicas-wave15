package com.example.be_java_hisp_w15_g07.unit.service;

import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.service.PostService;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    IUserRepository repository;
    @InjectMocks
    PostService service;

    @Test
    @DisplayName("T0005 - Verificar que el tipo de ordenamiento por fecha ascendente existe")
    public void getUserFollowedPostAscExists(){
        //Arrange
        Integer userId = 1;
        String order = "date_asc";

        //Mocks
        Mockito.when(repository.findById(userId)).thenReturn(UserFactory.getUserOne());

        //Act
        UserFollowedPostsDTO result = service.getFollowedPosts(userId, order);

        //Assert
        Assertions.assertEquals(UserFollowedPostsDTO.class, result.getClass());
    }

    @Test
    @DisplayName("T0005 - Verificar que el tipo de ordenamiento por fecha descendente existe")
    public void getUserFollowedPostDescExists(){
        //Arrange
        Integer userId = 1;
        String order = "date_desc";

        //Mocks
        Mockito.when(repository.findById(userId)).thenReturn(UserFactory.getUserOne());

        //Act
        UserFollowedPostsDTO result = service.getFollowedPosts(userId, order);

        //Assert
        Assertions.assertEquals(UserFollowedPostsDTO.class, result.getClass());
    }

    @Test
    @DisplayName("T0005 - Verificar si se lanza una excepcion cuando el tipo de ordenamiento no existe")
    public void getUserFollowedPostBadRequest(){
        //Assert
        Assertions.assertThrows(BadRequestException.class, () -> service.getFollowedPosts(1, "Otro ordenamiento"));
    }

    @Test
    @DisplayName("T0006 - Verificar el correcto ordenamiento ascendente por fecha")
    public void getUserFollowedPostAsc(){
        //Arrange
        Integer userId = 1;
        String order = "date_asc";
        UserFollowedPostsDTO expected = UserFactory.getUserOneFollowedDTOAsc();

        //Mocks
        Mockito.when(repository.findById(userId)).thenReturn(UserFactory.getUserOneWithFollowed());

        //Act
        UserFollowedPostsDTO result = service.getFollowedPosts(userId, order);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0006 - Verificar el correcto ordenamiento descendente por fecha")
    public void getUserFollowedPostDesc(){
        //Arrange
        Integer userId = 1;
        String order = "date_desc";
        UserFollowedPostsDTO expected = UserFactory.getUserOneFollowedDTODesc();

        //Mocks
        Mockito.when(repository.findById(userId)).thenReturn(UserFactory.getUserOneWithFollowed());

        //Act
        UserFollowedPostsDTO result = service.getFollowedPosts(userId, order);

        //Assert
        Assertions.assertEquals(expected, result);
    }
}
