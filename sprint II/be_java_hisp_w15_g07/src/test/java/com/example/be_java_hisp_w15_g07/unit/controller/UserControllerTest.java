package com.example.be_java_hisp_w15_g07.unit.controller;

import com.example.be_java_hisp_w15_g07.controller.UserController;
import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.service.IUserService;
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
    public void findExistingUser(){
        //arrange
        Integer userId = 1;
        Integer queryId = 2;
        ResponseEntity<?> expected = new ResponseEntity(HttpStatus.OK);

        //Mockito
        doNothing().when(service).followUser(userId, queryId);

        //act
        ResponseEntity<?> result = controller.followUser(userId, queryId);

        //assert
        assertEquals(expected, result);
        verify(service, times(1)).followUser(anyInt(), anyInt());
    }

    @Test
    @DisplayName("T0001 - Verificar que si el usuario a seguir no existe, lanza excepción")
    public void throwExceptionWhenUserNotFound(){
        //arrange
        Integer userId = 1;
        Integer queryId = -2;

        //Mockito
        doThrow(UserNotFoundException.class).when(service).followUser(userId, queryId);

        //act and assert
        assertThrows(UserNotFoundException.class, () -> controller.followUser(userId, queryId));
        verify(service, times(1)).followUser(anyInt(), anyInt());
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento por nombre ascendente existe")
    public void findFollowersOrderByNameAscExists(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";

        //Mocks
        Mockito.when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTOAsc());

        //Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento por nombre descendente existe")
    public void findFollowersOrderByNameDescExists(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";

        //Mocks
        Mockito.when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTODesc());

        //Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0005 - Verificar si se lanza una excepcion cuando el tipo de ordenamiento no existe")
    public void findFollowersOrderByNameBadRequest(){
        // Arrange
        Integer userId = 1;
        String order = "Otro ordenamiento";

        // Mock
        when(service.getFollowersList(userId, order)).thenThrow(BadRequestException.class);

        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> controller.getFollowersList(userId, order));
    }

    @Test
    @DisplayName("T0004 - Verificar el correcto ordenamiento ascendente por nombre")
    public void findFollowersOrderByNameAsc(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        ResponseEntity<FollowersDTO> expected = new ResponseEntity<>(UserFactory.getFollowersDTOAsc(),
                HttpStatus.OK);
        FollowersDTO expectedBody = UserFactory.getFollowersDTOAsc();

        //Mocks
        Mockito.when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTOAsc());

        //Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> Assertions.assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0004 - Verificar el correcto ordenamiento ascendente por nombre")
    public void findFollowersOrderByNameDesc(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        ResponseEntity<FollowersDTO> expected = new ResponseEntity<>(UserFactory.getFollowersDTODesc(),
                HttpStatus.OK);
        FollowersDTO expectedBody = UserFactory.getFollowersDTODesc();

        //Mocks
        Mockito.when(service.getFollowersList(userId, order)).thenReturn(UserFactory.getFollowersDTODesc());

        //Act
        ResponseEntity<FollowersDTO> result = controller.getFollowersList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> Assertions.assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento por nombre ascendente existe (followed)")
    public void findFollowedOrderByNameAscExists(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";

        //Mocks
        Mockito.when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTOAsc());

        //Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento por nombre descendente existe (followed)")
    public void findFollowedOrderByNameDescExists(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";

        //Mocks
        Mockito.when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTODesc());

        //Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(HttpStatus.OK, result.getStatusCode())
        );
    }

    @Test
    @DisplayName("T0005 - Verificar si se lanza una excepcion cuando el tipo de ordenamiento no existe")
    public void findFollowedOrderByNameBadRequest(){
        // Arrange
        Integer userId = 1;
        String order = "Otro ordenamiento";

        // Mock
        when(service.getFollowedList(userId, order)).thenThrow(BadRequestException.class);

        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> controller.getFollowedList(userId, order));
    }

    @Test
    @DisplayName("T0004 - Verificar el correcto ordenamiento ascendente por nombre (followed)")
    public void findFollowedOrderByNameAsc(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        ResponseEntity<FollowedDTO> expected = new ResponseEntity<>(UserFactory.getFollowedDTOAsc(),
                HttpStatus.OK);
        FollowedDTO expectedBody = UserFactory.getFollowedDTOAsc();

        //Mocks
        Mockito.when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTOAsc());

        //Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> Assertions.assertEquals(expectedBody, result.getBody())
        );
    }

    @Test
    @DisplayName("T0004 - Verificar el correcto ordenamiento ascendente por nombre (followed)")
    public void findFollowedOrderByNameDesc(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        ResponseEntity<FollowedDTO> expected = new ResponseEntity<>(UserFactory.getFollowedDTODesc(),
                HttpStatus.OK);
        FollowedDTO expectedBody = UserFactory.getFollowedDTODesc();

        //Mocks
        Mockito.when(service.getFollowedList(userId, order)).thenReturn(UserFactory.getFollowedDTODesc());

        //Act
        ResponseEntity<FollowedDTO> result = controller.getFollowedList(userId, order);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(ResponseEntity.class, result.getClass()),
                () -> Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode()),
                () -> Assertions.assertEquals(expectedBody, result.getBody())
        );
    }
}
