package com.example.be_java_hisp_w15_g07.unit.controller;

import com.example.be_java_hisp_w15_g07.controller.UserController;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.service.IUserService;
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
    @DisplayName("T00001 - Verificar que el usuario a seguir exista")
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
    @DisplayName("T00001 - Verificar que si el usuario a seguir no existe, lanza excepción")
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
    @DisplayName("T00002 - Verificar que el usuario a dejar de seguir exista")
    public void findExistingUserToUnfollow(){
        //arrange
        Integer userId = 1;
        Integer queryId = 2;
        ResponseEntity<?> expected = new ResponseEntity(HttpStatus.OK);

        //Mockito
        doNothing().when(service).unfollowUser(userId, queryId);

        //act
        ResponseEntity<?> result = controller.unfollowUser(userId, queryId);

        //assert
        assertEquals(expected, result);
        verify(service, times(1)).unfollowUser(anyInt(), anyInt());
    }

    @Test
    @DisplayName("T00002 - Verificar que si el usuario a dejar de seguir no existe, lanza excepción")
    public void throwExceptionWhenUserToUnfollowNotFound(){
        //arrange
        Integer userId = 1;
        Integer queryId = -2;

        //Mockito
        doThrow(UserNotFoundException.class).when(service).unfollowUser(userId, queryId);

        //act and assert
        assertThrows(UserNotFoundException.class, () -> controller.unfollowUser(userId, queryId));
        verify(service, times(1)).unfollowUser(anyInt(), anyInt());
    }
}
