package com.sprint.be_java_hisp_w15_g10.unit.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Exception.NotFollowException;
import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import com.sprint.be_java_hisp_w15_g10.Service.UserService;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    ModelMapper modelMapper;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userServiceMock;

    @Test
    @DisplayName("Test User With Followers Count")
    void getUsersWithFollowersCount() {
        // arrange
        User user = TestUtils.createUser(1, "Luis");
        TestUtils.addFollowers(user, 1);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(user));
        Mockito.when(modelMapper.map(user, UserWithFollowersCountDTO.class))
                .thenReturn(new UserWithFollowersCountDTO(user.getUser_id(), user.getUser_name()));
        // act
        UserWithFollowersCountDTO userWithFollowersCountDTO = userServiceMock.getUsersWithFollowersCount(1);
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(userWithFollowersCountDTO.getUser_name(), "Luis");},
                ()->{Assertions.assertEquals(userWithFollowersCountDTO.getUser_id(), 1);},
                ()->{Assertions.assertEquals(userWithFollowersCountDTO.getFollowers_count(),5);}
        );
    }

    @Test
    @DisplayName("Test Invalid User With Followers Count")
    void getInvalidUsersWithFollowersCount() {
        // arrange
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.empty());
        // act & assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.getUsersWithFollowersCount(1));
    }

    /**
     * Valida que el método del servicio unFollowUser regrese una excepción cuando no encuentre al usuario indicado en los parámetros.
     */
    @Test
    @DisplayName("Validar que lanza excepción al dejar de seguir a usuario inexitente")
    void unfollowUserUnknownUser() {
        // arrange
        Optional<User> oUser = Optional.empty();
        Mockito.when(userRepository.getById(Mockito.anyInt())).thenReturn(oUser);
        //act
        // assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.unfollowUser(1, 2));
    }

    /**
     * Valida que el método unfollowUser regrese un unfollowUseDTO
     */
    @Test
    @DisplayName("Validar que el cliente deje de seguir al vendedor")
    void unfollowUser() {
        // arrange
        User cliente = TestUtils.createUser(1, "Luis");
        User vendedor = TestUtils.createUser(2, "David");
        TestUtils.followUser(cliente, vendedor);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(cliente));
        Mockito.when(userRepository.getById(2)).thenReturn(Optional.of(vendedor));
        //act
        UnfollowUserDTO unfollowUserDTO = userServiceMock.unfollowUser(1,2);
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(unfollowUserDTO.getMessage(),"Se ha dejado de seguir al usuario: " + vendedor.getUser_name());},
                ()->{Assertions.assertFalse(cliente.getFollowed().contains(vendedor));}
        );
    }

    /**
     * Valida que el método unfollowUser retorne una excepción al dejar de seguir a un usuario no seguido
     */
    @Test
    @DisplayName(" Test unfollow Unfollowed User")
    void unfollowUnfollowedUser() {
        // arrange
        User cliente = TestUtils.createUser(1, "Luis");
        User vendedor = TestUtils.createUser(2, "David");
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(cliente));
        Mockito.when(userRepository.getById(2)).thenReturn(Optional.of(vendedor));
        // act & assert
        Assertions.assertThrows(NotFollowException.class, ()->userServiceMock.unfollowUser(1,2));
    }

    @Test
    void followUser() {
    }

    @Test
    void getInvalidUserFollowedUsers() {
        // arrange
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.empty());
        // act & assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.getVendorsFollow(1, ""));
    }

    @Test
    void getUserFollowedUsersOrderASC() {
        // arrange
        User user = TestUtils.createUser(1,"Luis");
        TestUtils.addFollowed(user, 1);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(user));
        // act
        VendedorsFollowedDTO vendedorsFollowedDTO = userServiceMock.getVendorsFollow(1, "name_asc");
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertFalse(vendedorsFollowedDTO.getFollowed().isEmpty());},
                ()->{Assertions.assertEquals(vendedorsFollowedDTO.getFollowed().size(), 5);},
                ()->{Assertions.assertEquals(vendedorsFollowedDTO.getUserName(), user.getUser_name());},
                ()->{Assertions.assertEquals(vendedorsFollowedDTO.getUserId(), user.getUser_id());},
                ()->{Assertions.assertTrue( List.of("Alfredo", "Daniel", "David", "Jesus", "Jorge")
                        .equals(vendedorsFollowedDTO.getFollowed()
                                .stream()
                                .map(UserDTO::getUser_name)
                                .collect(Collectors.toList())));}
        );
    }

    @Test
    void getUserFollowedUsersOrderDESC() {
        // arrange
        User user = TestUtils.createUser(1,"Luis");
        TestUtils.addFollowed(user, 1);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(user));
        // act
        VendedorsFollowedDTO vendedorsFollowedDTO = userServiceMock.getVendorsFollow(1, "name_desc");
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertFalse(vendedorsFollowedDTO.getFollowed().isEmpty());},
                ()->{Assertions.assertEquals(vendedorsFollowedDTO.getFollowed().size(), 5);},
                ()->{Assertions.assertEquals(vendedorsFollowedDTO.getUserName(), user.getUser_name());},
                ()->{Assertions.assertEquals(vendedorsFollowedDTO.getUserId(), user.getUser_id());},
                ()->{Assertions.assertTrue( List.of("Jorge", "Jesus", "David", "Daniel", "Alfredo")
                        .equals(vendedorsFollowedDTO.getFollowed()
                                .stream()
                                .map(UserDTO::getUser_name)
                                .collect(Collectors.toList())));}
        );
    }

    @Test
    void getInvalidUserWithFollowers() {
        // arrange
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.empty());
        // act & assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.getFollowers(1, ""));
    }

    @Test
    void getUserWithFollowersOrderASC() {
        // arrange
        User user = TestUtils.createUser(1,"Luis");
        TestUtils.addFollowers(user, 1);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(user));
        // act
        FollowersDTO followersDTO = userServiceMock.getFollowers(1, "name_asc");
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertFalse(followersDTO.getFollowers().isEmpty());},
                ()->{Assertions.assertEquals(followersDTO.getFollowers().size(), 5);},
                ()->{Assertions.assertEquals(followersDTO.getUserName(), user.getUser_name());},
                ()->{Assertions.assertEquals(followersDTO.getUserId(), user.getUser_id());},
                ()->{Assertions.assertTrue( List.of("Alfredo", "Daniel", "David", "Jesus", "Jorge")
                        .equals(followersDTO.getFollowers()
                                .stream()
                                .map(UserDTO::getUser_name)
                                .collect(Collectors.toList())));}
        );
    }

    @Test
    void getUserWithFollowersOrderDESC() {
        // arrange
        User user = TestUtils.createUser(1,"Luis");
        TestUtils.addFollowers(user, 1);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(user));
        // act
        FollowersDTO followersDTO = userServiceMock.getFollowers(1, "name_desc");
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertFalse(followersDTO.getFollowers().isEmpty());},
                ()->{Assertions.assertEquals(followersDTO.getFollowers().size(), 5);},
                ()->{Assertions.assertEquals(followersDTO.getUserName(), user.getUser_name());},
                ()->{Assertions.assertEquals(followersDTO.getUserId(), user.getUser_id());},
                ()->{Assertions.assertTrue( List.of("Jorge", "Jesus", "David", "Daniel", "Alfredo")
                        .equals(followersDTO.getFollowers()
                                .stream()
                                .map(UserDTO::getUser_name)
                                .collect(Collectors.toList())));}
        );
    }

}