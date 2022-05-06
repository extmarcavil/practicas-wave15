package com.example.be_java_hisp_w15_g07_ravelli.unit.repository;

import com.example.be_java_hisp_w15_g07_ravelli.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07_ravelli.model.User;
import com.example.be_java_hisp_w15_g07_ravelli.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07_ravelli.repository.UserRepository;
import com.example.be_java_hisp_w15_g07_ravelli.utils.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRepositoryTest {
    private IUserRepository repository;

    @BeforeEach
    public void setup(){
        repository = new UserRepository();
    }

    @Test
    @DisplayName("T0001/02 - Verificar que el usuario a seguir existe")
    public void findUserSuccess(){
        // Arrange
        Integer queryId = 1;
        User expected = UserFactory.getUserOne();

        // Act
        User result = repository.findById(queryId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0001/02 - Verificar que se lanza una excepción si el usuario a seguir no existe")
    public void findUserNotFound(){
        // Arrange
        Integer userId = -1;

        // Act and assert
        assertThrows(UserNotFoundException.class, () -> repository.findById(userId));
    }

    @Test
    @DisplayName("T0003 - (Followers ascendente) Verificar que se lanza una excepción si no existe el usuario")
    public void findFollowersOrderByNameAscNotFound(){
        // Arrange
        Integer userId = -1;

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> repository.findFollowersOrderByNameAsc(userId));
    }

    @Test
    @DisplayName("T0003 - (Followers descendente) Verificar que se lanza una excepción si no existe el usuario")
    public void findFollowersOrderByNameDescNotFound(){
        // Arrange
        Integer userId = -1;

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> repository.findFollowersOrderByNameDesc(userId));
    }

    @Test
    @DisplayName("T0003 - (Followed ascendente) Verificar que se lanza una excepción si no existe el usuario")
    public void findFollowedOrderByNameAscNotFound(){
        // Arrange
        Integer userId = -1;

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> repository.findFollowedOrderByNameAsc(userId));
    }

    @Test
    @DisplayName("T0003 - (Followed descendente) Verificar que se lanza una excepción si no existe el usuario")
    public void findFollowedOrderByNameDescNotFound(){
        // Arrange
        Integer userId = -1;

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> repository.findFollowedOrderByNameDesc(userId));
    }

    @Test
    @DisplayName("T0004 - (Followers) Verificar que el ordenamiento alfabético ascendente es correcto")
    public void findFollowersOrderByNameAscSuccess(){
        // Arrange
        Integer userId = 2;
        List<User> expected = Arrays.asList(UserFactory.getUserOne(), UserFactory.getUserThree());

        // Act
        List<User> result = repository.findFollowersOrderByNameAsc(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0004 - (Followers) Verificar que el ordenamiento alfabético descendente es correcto")
    public void findFollowersOrderByNameDescSuccess(){
        // Arrange
        Integer userId = 2;
        List<User> expected = Arrays.asList(UserFactory.getUserThree(), UserFactory.getUserOne());

        // Act
        List<User> result = repository.findFollowersOrderByNameDesc(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0004 - (Followed) Verificar que el ordenamiento alfabético ascendente sea correcto")
    public void findFollowedOrderByNameAscSuccess(){
        // Arrange
        Integer userId = 1;
        List<User> expected = Arrays.asList(UserFactory.getUserTwo(), UserFactory.getUserThree());

        // Act
        List<User> result = repository.findFollowedOrderByNameAsc(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0004 - (Followed) Verificar que el ordenamiento alfabético descendente sea correcto")
    public void findFollowedOrderByNameDescSuccess(){
        // Arrange
        Integer userId = 1;
        List<User> expected = Arrays.asList(UserFactory.getUserThree(), UserFactory.getUserTwo());

        // Act
        List<User> result = repository.findFollowedOrderByNameDesc(userId);

        // Assert
        assertEquals(expected, result);
    }
}
