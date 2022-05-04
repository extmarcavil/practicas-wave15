package com.sprint.be_java_hisp_w15_g10.unit.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.UnfollowUserDTO;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userServiceMock;

    @Test
    void getUsersWithFollowersCount() {
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

    @Test
    @DisplayName("Validar que el cliente deje de seguir al vendedor")
    void unfollowUser() {
        // arrange
        User cliente = TestUtils.createUser(1, "Luis");
        User vendedor = TestUtils.createUser(2, "David");
        TestUtils.FollowUser(cliente, vendedor);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(cliente));
        Mockito.when(userRepository.getById(2)).thenReturn(Optional.of(vendedor));
        //act
        UnfollowUserDTO unfollowUserDTO = userServiceMock.unfollowUser(1,2);
        // assert
        Assertions.assertEquals(unfollowUserDTO.getMessage(),"Se ha dejado de seguir al usuario: " + vendedor.getUser_name());
    }

    @Test
    void followUser() {
    }

    @Test
    void getVendorsFollow() {
    }

    @Test
    void getFollowers() {
    }
}