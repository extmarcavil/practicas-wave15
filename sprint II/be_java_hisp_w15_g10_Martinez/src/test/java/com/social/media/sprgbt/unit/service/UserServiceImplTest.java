package com.social.media.sprgbt.unit.service;

import com.social.media.sprgbt.dto.UserDto;
import com.social.media.sprgbt.entity.User;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.UserMapper;
import com.social.media.sprgbt.repository.IUserRepository;
import com.social.media.sprgbt.service.impl.UserServiceImpl;
import com.social.media.sprgbt.utils.Data;
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
class UserServiceImplTest {


    /**
     * Mocks
     */
    @Mock
    IUserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userServiceImpl;


    /**
     * Tests
     */

    @Test
    @DisplayName("Test Create User")
    void createUserTest() {
        //Arrange
        when(userRepository.getUserByUsername(Data.USERDTO_JUAN.getUserName())).thenReturn(null);

        when(userMapper.mapToEntity(Data.USERDTO_JUAN)).thenReturn(Data.USER_JUAN);

        when(userRepository.createUser(Data.USER_JUAN)).then(invocationOnMock -> {
            Data.USER_JUAN.setUserId(1);
            return Data.USER_JUAN;
        });

        when(userMapper.mapToDto(Data.USER_JUAN)).then(invocationOnMock -> {
            Data.USERDTO_JUAN.setUserId(1);
            return Data.USERDTO_JUAN;
        });

        //Act
        UserDto userDtoResult = userServiceImpl.createUser(Data.USERDTO_JUAN);

        //Assert
        assertAll(
                () -> assertNotNull(userDtoResult),
                () -> assertEquals(1, userDtoResult.getUserId()),
                () -> assertEquals("Juan", userDtoResult.getUserName()),
                () -> assertEquals(0, userDtoResult.getFollowersCount()),
                () -> assertEquals(0, userDtoResult.getFollowers().size()),
                () -> assertEquals(1, userDtoResult.getFollowed().size())
        );

        verify(userRepository, atLeastOnce()).getUserByUsername(any(String.class));
        verify(userMapper, atLeastOnce()).mapToEntity(any(UserDto.class));
        verify(userRepository, atLeastOnce()).createUser(any(User.class));
        verify(userMapper, atLeastOnce()).mapToDto(any(User.class));
    }


    //Verificar que el usuario a seguir exista. (US-0001)
    @Test
    @DisplayName("Test Create User existing ")
    void createUserExistingTest() {
        //Arrange
        when(userRepository.getUserByUsername(Data.USERDTO_JUAN.getUserName()))
                .thenReturn(Data.USER_JUAN);

        //Act
        //Assert
        ExistingException e = assertThrows(ExistingException.class, () ->
                userServiceImpl.createUser(Data.USERDTO_JUAN));

        assertEquals("El Usuario con userName: Juan ya existe en la BD.", e.getMessage());
        verify(userRepository, atLeastOnce()).getUserByUsername(any(String.class));

    }


    @Test
    @DisplayName("Test Get All Users")
    void getAllUsersTest() {
        //Arrange
        Data.USER_JUAN.setUserId(1);
        when(userRepository.getAllUsers()).then(invocationOnMock -> {
            return Arrays.asList(Data.USER_JUAN);
        });

        when(userMapper.mapToDto(Data.USER_JUAN)).then(invocationOnMock -> {
            Data.USERDTO_JUAN.setUserId(1);
            return Data.USERDTO_JUAN;
        });

        //Act
        List<UserDto> userDtoResult = userServiceImpl.getAllUsers();

        //Assert
        assertAll(
                () -> assertNotNull(userDtoResult),
                () -> assertEquals(1, userDtoResult.get(0).getUserId()),
                () -> assertEquals("Juan", userDtoResult.get(0).getUserName()),
                () -> assertEquals(0, userDtoResult.get(0).getFollowersCount()),
                () -> assertEquals(0, userDtoResult.get(0).getFollowers().size()),
                () -> assertEquals(1, userDtoResult.get(0).getFollowed().size())
        );

        verify(userRepository, atLeastOnce()).getAllUsers();
        verify(userMapper, atLeastOnce()).mapToDto(any(User.class));
    }


    @Test
    @DisplayName("Test Get User By Username")
    void getUserByUsernameTest() {
        //Arrange
        when(userRepository.getUserByUsername(Data.USERDTO_JUAN.getUserName())).then(invocationOnMock -> {
            Data.USER_JUAN.setUserId(1);
            return Data.USER_JUAN;
        });

        when(userMapper.mapToDto(Data.USER_JUAN)).then(invocationOnMock -> {
            Data.USERDTO_JUAN.setUserId(1);
            return Data.USERDTO_JUAN;
        });

        //Act
        UserDto userDtoResult = userServiceImpl.getUserByUsername(Data.USERDTO_JUAN.getUserName());

        //Assert
        assertAll(
                () -> assertNotNull(userDtoResult),
                () -> assertEquals(1, userDtoResult.getUserId()),
                () -> assertEquals("Juan", userDtoResult.getUserName()),
                () -> assertEquals(0, userDtoResult.getFollowersCount()),
                () -> assertEquals(0, userDtoResult.getFollowers().size()),
                () -> assertEquals(1, userDtoResult.getFollowed().size())
        );

        verify(userRepository, atLeastOnce()).getUserByUsername(any(String.class));
        verify(userMapper, atLeastOnce()).mapToDto(any(User.class));
    }


    @Test
    @DisplayName("Test Get User By Username Not Found")
    void getUserByUsernameNotFoundTest() {
        //Arrange
        when(userRepository.getUserByUsername(Data.USERDTO_JUAN.getUserName())).thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () ->
                userServiceImpl.getUserByUsername(Data.USERDTO_JUAN.getUserName())
        );
        assertEquals("El Usuario con userName: Juan no existe en la BD.", e.getMessage());
        verify(userRepository, atLeastOnce()).getUserByUsername(any(String.class));
    }


    @Test
    @DisplayName("Test Check User Given Id")
    void getUserByIdTest() {
        //Arrange
        when(userRepository.getUserById(1)).then(invocationOnMock -> {
            Data.USER_JUAN.setUserId(1);
            return Data.USER_JUAN;
        });

        when(userMapper.mapToDto(Data.USER_JUAN)).then(invocationOnMock -> {
            Data.USERDTO_JUAN.setUserId(1);
            return Data.USERDTO_JUAN;
        });

        //Act
        UserDto userDtoResult = userServiceImpl.getUserById(1);

        //Assert
        assertAll(
                () -> assertNotNull(userDtoResult),
                () -> assertEquals(1, userDtoResult.getUserId()),
                () -> assertEquals("Juan", userDtoResult.getUserName()),
                () -> assertEquals(0, userDtoResult.getFollowersCount()),
                () -> assertEquals(0, userDtoResult.getFollowers().size()),
                () -> assertEquals(1, userDtoResult.getFollowed().size())
        );

        verify(userRepository, atLeastOnce()).getUserById(anyInt());
        verify(userMapper, atLeastOnce()).mapToDto(any(User.class));
    }


    @Test
    @DisplayName("Test Get User By Id Not Found")
    void getUserByIdNotFoundTest() {
        //Arrange
        when(userRepository.getUserById(1)).thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () ->
                userServiceImpl.getUserById(1)
        );
        assertEquals("El Usuario con userId: 1 no existe en la BD.", e.getMessage());
        verify(userRepository, atLeastOnce()).getUserById(anyInt());
    }
}