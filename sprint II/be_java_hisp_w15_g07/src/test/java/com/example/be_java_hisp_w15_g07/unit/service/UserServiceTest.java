package com.example.be_java_hisp_w15_g07.unit.service;

import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.service.UserService;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento alfabético ascendente exista")
    public void findFollowersOrderByNameAsc(){
        // Arrange
        Integer userId = 2;
        String order = "name_asc";
        List<User> followers = Arrays.asList(UserFactory.getUserOne(), UserFactory.getUserThree());
        FollowersDTO expected = UserFactory.getFollowersDTOAsc();

        // Mock
        when(repository.findFollowersOrderByNameAsc(userId)).thenReturn(followers);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(1)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act
        FollowersDTO result = service.getFollowersList(userId, order);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento alfabético descendente exista")
    public void findFollowersOrderByNameDesc(){
        // Arrange
        Integer userId = 2;
        String order = "name_desc";
        List<User> followers = Arrays.asList(UserFactory.getUserThree(), UserFactory.getUserOne());
        FollowersDTO expected = UserFactory.getFollowersDTODesc();

        // Mock
        when(repository.findFollowersOrderByNameDesc(userId)).thenReturn(followers);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(1)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act
        FollowersDTO result = service.getFollowersList(userId, order);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0003 - Verificar que se lanza una excepción cuando el tipo de ordenamiento no existe")
    public void findFollowersOrderByNameBadRequest(){
        // Assert
        assertThrows(BadRequestException.class, () -> service.getFollowersList(1, "otro_ordenamiento"));
    }
}
