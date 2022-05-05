package com.sprint.be_java_hisp_w15_g10.unit.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Exception.FollowException;
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

    /**
     * Test para el metodo @link{UserService#getUsersWithFollowersCount(int)}
     * el test se realiza con un usuario que existe en la base de datos y arroja una respuesta con el usuario encontrado.
     */ 
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
                ()->{Assertions.assertEquals(userWithFollowersCountDTO.getFollowers_count(),5);},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }
    /**
     * V que se arroja una excepcion cuando el usuario no existe en la base de datos.
     */
    @Test
    @DisplayName("Test Invalid User With Followers Count")
    void getInvalidUsersWithFollowersCount() {
        // arrange
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.empty());
        // act & assert
        Assertions.assertAll(
                ()->{Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.getUsersWithFollowersCount(1));},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }

    /**
     * Valida que el método del servicio unFollowUser regrese una excepción cuando no encuentre al usuario indicado en los parámetros.
     */
    @Test
    @DisplayName("Validar que lanza excepción al dejar de seguir a usuario inexitente")
    void unfollowUserUnknownUser() {
        // arrange
        Mockito.when(userRepository.getById(Mockito.anyInt())).thenReturn(Optional.empty());
        //act
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.unfollowUser(1, 2));},
                ()->{Mockito.verify(userRepository, Mockito.atLeast(1)).getById(Mockito.anyInt());}
        );
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
                ()->{Assertions.assertFalse(cliente.getFollowed().contains(vendedor));},
                ()->{Assertions.assertFalse(vendedor.getFollowers().contains(cliente));},
                ()->{Mockito.verify(userRepository, Mockito.times(2)).getById(Mockito.anyInt());}
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
        Assertions.assertAll(
                ()->{Assertions.assertThrows(NotFollowException.class, ()->userServiceMock.unfollowUser(1,2));},
                ()->{Mockito.verify(userRepository, Mockito.atLeast(1)).getById(Mockito.anyInt());}
        );
    }

    //T-0001 Service
    @Test
    @DisplayName("Validando que el usuario a seguir existe")
    void followUserTest() {
        //Arrange
        User cliente = TestUtils.createUser(1, "Luis");
        User vendedor = TestUtils.createUser(2, "David");
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(cliente));
        Mockito.when(userRepository.getById(2)).thenReturn(Optional.of(vendedor));

        //Act
        FollowUserDTO msj = userServiceMock.followUser(1, 2);

        //Assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals("Se ha comenzado a seguir al usuario: David", msj.getMessage());},
                ()->{Assertions.assertTrue(cliente.getFollowed().contains(vendedor));},
                ()->{Assertions.assertTrue(vendedor.getFollowers().contains(cliente));},
                ()->{Mockito.verify(userRepository, Mockito.times(2)).getById(Mockito.anyInt());}
        );
    }

    //T-0001 Service
    @Test
    @DisplayName("Notificando la no existencia del usuario a seguir lanzando la excepcion")
    void followUserInexistsTest() {
        //Arrange
        Mockito.when(userRepository.getById(Mockito.anyInt())).thenReturn(Optional.empty());
        //Act & Assert
        Assertions.assertAll(
                ()->{Assertions.assertThrows(UserNotFoundException.class, () ->userServiceMock.followUser(1, 10));},
                ()->{Mockito.verify(userRepository, Mockito.atLeast(1)).getById(Mockito.anyInt());}
        );
    }

    @Test
    @DisplayName(" Test unfollow Unfollowed User")
    void followFollowedUser() {
        // arrange
        User cliente = TestUtils.createUser(1, "Luis");
        User vendedor = TestUtils.createUser(2, "David");
        TestUtils.followUser(cliente, vendedor);
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.of(cliente));
        Mockito.when(userRepository.getById(2)).thenReturn(Optional.of(vendedor));
        // act & assert
        Assertions.assertAll(
                ()->{Assertions.assertThrows(FollowException.class, ()->userServiceMock.followUser(1,2));},
                ()->{Mockito.verify(userRepository, Mockito.times(2)).getById(Mockito.anyInt());}
        );

    }

    @Test
    @DisplayName("Test de la lista de usuarios seguidos")
    void getInvalidUserFollowedUsers() {
        // arrange
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.empty());
        // act & assert
        Assertions.assertAll(
                ()->{Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.getVendorsFollow(1, ""));},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }
     /**
     * El test valida que la lista de retorno de usuarios seguidos sea ordenada de forma descendente
     */
    @Test
    @DisplayName("Test de validacion de ordenamiento ascendente de usuarios seguidos")
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
                                .collect(Collectors.toList())));},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }
    /**
     * El test valida que la lista de retorno de usuarios seguidos sea ordenada de forma descendente
     */
    @Test
    @DisplayName("Test de validacion de ordenamiento descendente de usuarios seguidos")
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
                                .collect(Collectors.toList())));},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }
    /**
     * 
     */
    @Test
    void getInvalidUserWithFollowers() {
        // arrange
        Mockito.when(userRepository.getById(1)).thenReturn(Optional.empty());
        // act & assert
        Assertions.assertAll(
                ()->{Assertions.assertThrows(UserNotFoundException.class, () -> userServiceMock.getFollowers(1, ""));},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }

     /**
     * El test valida que la lista de retorno de usuarios que siguen a un usuario sea ordenada de forma descendente
     */
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
                                .collect(Collectors.toList())));},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }

     /**
     * El test valida que la lista de retorno de usuarios que siguen a un usuario sea ordenada de forma descendente
     */
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
                                .collect(Collectors.toList())));},
                ()->{Mockito.verify(userRepository, Mockito.times(1)).getById(Mockito.anyInt());}
        );
    }
}