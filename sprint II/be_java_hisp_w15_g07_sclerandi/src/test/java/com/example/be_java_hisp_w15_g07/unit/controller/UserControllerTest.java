package com.example.be_java_hisp_w15_g07.unit.controller;

import com.example.be_java_hisp_w15_g07.controller.UserController;
import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.service.IUserService;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    IUserService service;

    @InjectMocks
    UserController controller;

    @Test
    @DisplayName("T0001 - Verificar que el usuario a seguir exista")
    public void findUserToFollow(){
        // Arrange
        Integer userId = 1;
        Integer queryId = 2;
        ResponseEntity<?> expected = new ResponseEntity<>(HttpStatus.OK);

        // Mock
        doNothing().when(service).followUser(userId, queryId);

        // Act
        ResponseEntity<?> result = controller.followUser(userId, queryId);

        // Assert
        assertEquals(expected.getStatusCode(), result.getStatusCode());
        assertEquals(expected, result);
        verify(service, times(1)).followUser(anyInt(), anyInt());
    }

    @Test
    @DisplayName("T0001 - Verificar que se lanza una expcepción si el usuario a seguir no existe")
    public void findUserToFollowNotFound(){
        // Arrange
        Integer userId = 1;
        Integer queryId = -2;

        // Mock
        doThrow(UserNotFoundException.class).when(service).followUser(userId, queryId);

        // Act and assert
        assertThrows(UserNotFoundException.class, () -> controller.followUser(userId, queryId));
        verify(service, times(1)).followUser(anyInt(), anyInt());
    }

    @Test
    @DisplayName("T0002 - Verificar que el usuario a dejar de seguir existe")
    public void findUserToUnfollow(){
        // Arrange
        Integer userId = 1;
        Integer queryId = 2;
        ResponseEntity<?> expected = new ResponseEntity<>(HttpStatus.OK);

        // Mock
        doNothing().when(service).unfollowUser(userId, queryId);

        // Act
        ResponseEntity<?> result = controller.unfollowUser(userId, queryId);

        // Assert
        assertEquals(expected.getStatusCode(), result.getStatusCode());
        assertEquals(expected, result);
        verify(service, times(1)).unfollowUser(anyInt(), anyInt());
    }

    @Test
    @DisplayName("T0002 - Verificar que se lanza una expcepción si el usuario a dejar de seguir no existe")
    public void FindUserToUnfollowNotFound(){
        // Arrange
        Integer userId = 1;
        Integer queryId = -2;

        // Mock
        doThrow(UserNotFoundException.class).when(service).unfollowUser(userId, queryId);

        // Act and assert
        assertThrows(UserNotFoundException.class, () -> controller.unfollowUser(userId, queryId));
        verify(service, times(1)).unfollowUser(anyInt(), anyInt());
    }
          
    @Test
    @DisplayName("T0003 - (Followers) Verificar que el tipo de ordenamiento por nombre ascendente existe")
    public void findFollowersOrderByNameAscExists(){
        // Arrange
        Integer userId = 1;
        String order = "name_asc";

        // Mock
        when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTOAsc());

        // Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0003 - (Followers) Verificar que el tipo de ordenamiento por nombre descendente existe")
    public void findFollowersOrderByNameDescExists(){
        // Arrange
        Integer userId = 1;
        String order = "name_desc";

        // Mock
        when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTODesc());

        // Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0003 - (Followed) Verificar que el tipo de ordenamiento por nombre ascendente existe")
    public void findFollowedOrderByNameAscExists(){
        // Arrange
        Integer userId = 1;
        String order = "name_asc";

        // Mock
        when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTOAsc());

        // Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0003 - (Followed) Verificar que el tipo de ordenamiento por nombre descendente existe")
    public void findFollowedOrderByNameDescExists(){
        // Arrange
        Integer userId = 1;
        String order = "name_desc";

        // Mock
        when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTODesc());

        // Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0003 - (Followers) Verificar si se lanza una excepcion cuando el tipo de ordenamiento no existe")
    public void findFollowersOrderByNameBadRequest(){
        // Arrange
        Integer userId = 1;
        String order = "Otro ordenamiento";

        // Mock
        when(service.getFollowersList(userId, order)).thenThrow(BadRequestException.class);

        // Assert
        assertThrows(BadRequestException.class, () -> controller.getFollowersList(userId, order));
    }

    @Test
    @DisplayName("T0003 - (Followed) Verificar si se lanza una excepcion cuando el tipo de ordenamiento no existe")
    public void findFollowedOrderByNameBadRequest(){
        // Arrange
        Integer userId = 1;
        String order = "Otro ordenamiento";

        // Mock
        when(service.getFollowedList(userId, order)).thenThrow(BadRequestException.class);

        // Assert
        assertThrows(BadRequestException.class, () -> controller.getFollowedList(userId, order));
    }

    @Test
    @DisplayName("T0004 - (Followers) Verificar el correcto ordenamiento ascendente por nombre")
    public void findFollowersOrderByNameAsc(){
        // Arrange
        Integer userId = 1;
        String order = "name_asc";
        ResponseEntity<FollowersDTO> expected = new ResponseEntity<>(UserFactory.getFollowersDTOAsc(),
                HttpStatus.OK);
        FollowersDTO expectedBody = UserFactory.getFollowersDTOAsc();

        // Mock
        when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTOAsc());

        // Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0004 - (Followers) Verificar el correcto ordenamiento ascendente por nombre")
    public void findFollowersOrderByNameDesc(){
        // Arrange
        Integer userId = 1;
        String order = "name_desc";
        ResponseEntity<FollowersDTO> expected = new ResponseEntity<>(UserFactory.getFollowersDTODesc(),
                HttpStatus.OK);
        FollowersDTO expectedBody = UserFactory.getFollowersDTODesc();

        // Mock
        when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTODesc());

        // Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0004 - (Followed) Verificar el correcto ordenamiento ascendente por nombre")
    public void findFollowedOrderByNameAsc(){
        // Arrange
        Integer userId = 1;
        String order = "name_asc";
        ResponseEntity<FollowedDTO> expected = new ResponseEntity<>(UserFactory.getFollowedDTOAsc(),
                HttpStatus.OK);
        FollowedDTO expectedBody = UserFactory.getFollowedDTOAsc();

        // Mock
        when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTOAsc());

        // Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0004 - (Followed) Verificar el correcto ordenamiento ascendente por nombre")
    public void findFollowedOrderByNameDesc(){
        // Arrange
        Integer userId = 1;
        String order = "name_desc";
        ResponseEntity<FollowedDTO> expected = new ResponseEntity<>(UserFactory.getFollowedDTODesc(),
                HttpStatus.OK);
        FollowedDTO expectedBody = UserFactory.getFollowedDTODesc();

        // Mock
        when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTODesc());

        // Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        // Assert
        assertAll(
                () -> assertEquals(ResponseEntity.class, result.getClass()),
                () -> assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0007 - Verificar que la cantidad de seguidores de un determinado usuario sea correcta ")
    public void returnsCorrectFollowersCount(){
        // Arrange
        User user1 = UserFactory.getUserOne();
        User user2 = UserFactory.getUserTwo();
        UserFactory.setFollowedList(user1, user2);

        FollowersCountDTO expectedResult = new FollowersCountDTO(2, "User 2", 1);
        ResponseEntity<FollowersCountDTO> expectedResponse = new ResponseEntity<>(expectedResult, HttpStatus.OK);

        // Mock
        when(service.followersCount(2)).thenReturn(expectedResult);

        // Act
        ResponseEntity<FollowersCountDTO> result = controller.countFollowers(2);

        // Assert
        assertAll(
                () -> assertEquals(expectedResponse.getBody(), result.getBody()),
                () -> assertEquals(expectedResponse.getStatusCode(), result.getStatusCode())
        );
    }
}
