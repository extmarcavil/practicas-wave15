package com.example.be_java_hisp_w15_g07.unit.service;

import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.service.IUserService;
import com.example.be_java_hisp_w15_g07.service.PostService;
import com.example.be_java_hisp_w15_g07.service.UserService;
import com.example.be_java_hisp_w15_g07.utils.PostFactory;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

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
    @DisplayName("T00002 - Verificar que el usuario a dejar de seguir exista")
    public void findExistingUserToUnfollow(){
        //arrange
        Integer userId = 1;
        Integer queryId = 2;
        User user1 = UserFactory.getUserOne();
        User user2 = UserFactory.getUserTwo();
        UserFactory.setFollowedList(user1, user2);

        //Mockito
        when(repository.findById(userId)).thenReturn(user1);
        when(repository.findById(queryId)).thenReturn(user2);

        //act and assert
        assertDoesNotThrow(() -> service.unfollowUser(userId, queryId));
        verify(repository, times(2)).findById(anyInt());
    }

    @Test
    @DisplayName("T00002 - Verificar que si el usuario a dejar de seguir no existe, lanza excepción")
    public void throwExceptionWhenUserToUnfollowNotFound(){
        //arrange
        Integer userId = 1;
        Integer queryId = -2;
        User user1 = UserFactory.getUserOne();

        //Mockito
        when(repository.findById(userId)).thenReturn(user1);
        when(repository.findById(queryId)).thenThrow(UserNotFoundException.class);

        //act and assert
        assertThrows(UserNotFoundException.class, () -> service.unfollowUser(userId, queryId));
        verify(repository, times(2)).findById(anyInt());
    }

    @Test
    @DisplayName("T0007 - Verificar que la cantidad de seguidores de un determinado usuario sea correcta ")
    public void returnsCorrectFollowersCount(){
        //arrange
        Integer userId = 2;
        User user1 = UserFactory.getUserOne();
        User user2 = UserFactory.getUserTwo();
        UserFactory.setFollowedList(user1, user2);

        int expectedFollowersCount = 1;

        //Mockito
        when(repository.findById(userId)).thenReturn(user2);

        //act
        FollowersCountDTO result = service.followersCount(user2.getUserId());

        //assert
        assertEquals(expectedFollowersCount, result.getFollowersCount());
    }

    @Test
    @DisplayName("T0007 - Verificar que la cantidad de seguidores de un determinado usuario sea 0 ")
    public void returnsCorrectFollowersCount0(){
        //arrange
        Integer userId = 1;
        User user1 = UserFactory.getUserOne();

        int expectedFollowersCount = 0;

        //Mockito
        when(repository.findById(userId)).thenReturn(user1);

        //act
        FollowersCountDTO result = service.followersCount(user1.getUserId());

        //assert
        assertEquals(expectedFollowersCount, result.getFollowersCount());
    }
}
