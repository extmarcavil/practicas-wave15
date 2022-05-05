package com.example.be_java_hisp_w15_g07.unit.service;

import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.service.IUserService;
import com.example.be_java_hisp_w15_g07.service.UserService;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private IUserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    @DisplayName("T00001 - Verificar que el usuario a seguir exista")
    public void findExistingUser(){
        //arrange
        Integer userId = 1;
        Integer queryId = 2;
        User user1 = UserFactory.getUserOne();
        User user2 = UserFactory.getUserTwo();

        //Mockito
        when(repository.findById(userId)).thenReturn(user1);
        when(repository.findById(queryId)).thenReturn(user2);

        //act and assert
        assertDoesNotThrow(() -> service.followUser(userId, queryId));
        verify(repository, times(2)).findById(anyInt());
    }

    @Test
    @DisplayName("T00001 - Verificar que si el usuario a seguir no existe, lanza excepción")
    public void throwExceptionWhenUserNotFound(){
        //arrange
        Integer userId = 1;
        Integer queryId = -2;
        User user1 = UserFactory.getUserOne();
        User user2 = UserFactory.getUserTwo();

        //Mockito
        when(repository.findById(userId)).thenReturn(user1);
        when(repository.findById(queryId)).thenThrow(UserNotFoundException.class);

        //act and assert
        assertThrows(UserNotFoundException.class, () -> service.followUser(userId, queryId));
        verify(repository, times(2)).findById(anyInt());
    }
}
