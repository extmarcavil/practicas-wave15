package com.example.be_java_hisp_w15_g07.unit.repository;

import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.repository.UserRepository;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    private IUserRepository repository;

    @BeforeEach
    public void setup(){
        repository = new UserRepository();
    }

    @Test
    @DisplayName("T0001 - Verificar que el usuario a seguir exista")
    public void findExistingUser(){
        //arrange
        Integer queryId = 1;
        User expected = UserFactory.getUserOne();

        //act
        User result = repository.findById(queryId);

        //assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0001 - Verificar que si el usuario a seguir no existe, lanza excepción")
    public void throwsExceptionWhenUserNotFound(){
        //arrange
        Integer queryId = -1; //IDs are always positive

        //act and assert
        assertThrows(UserNotFoundException.class, () -> repository.findById(queryId));
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento alfabético exista")
    public void findFollowersOrderByNameAsc(){
        // Arrange
        Integer userId = 2;
        List<User> expected = Arrays.asList(UserFactory.getUserOne(), UserFactory.getUserThree());

        // Act
        List<User> result = repository.findFollowersOrderByNameAsc(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0003 - Verificar que set lance una excepción si no existe el usuario.")
    public void findFollowersOrderByNameAscNotFound(){
        // Arrange
        Integer userId = -2;

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> repository.findFollowersOrderByNameAsc(userId));
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento alfabético exista (followed)")
    public void findFollowedOrderByNameAsc(){
        // Arrange
        Integer userId = 1;
        List<User> expected = Arrays.asList(UserFactory.getUserTwo(), UserFactory.getUserThree());

        // Act
        List<User> result = repository.findFollowedOrderByNameAsc(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0003 - Verificar que set lance una excepción si no existe el usuario (followed)")
    public void findFollowedOrderByNameAscNotFound(){
        // Arrange
        Integer userId = -2;

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> repository.findFollowedOrderByNameAsc(userId));
    }

    @Test
    @DisplayName("T0003 - Verificar que el tipo de ordenamiento alfabético exista (followed)")
    public void findFollowedOrderByNameDesc(){
        // Arrange
        Integer userId = 1;
        List<User> expected = Arrays.asList(UserFactory.getUserThree(), UserFactory.getUserTwo());

        // Act
        List<User> result = repository.findFollowedOrderByNameDesc(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0003 - Verificar que set lance una excepción si no existe el usuario (followed)")
    public void findFollowedOrderByNameDescNotFound(){
        // Arrange
        Integer userId = -2;

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> repository.findFollowedOrderByNameDesc(userId));
    }
}
