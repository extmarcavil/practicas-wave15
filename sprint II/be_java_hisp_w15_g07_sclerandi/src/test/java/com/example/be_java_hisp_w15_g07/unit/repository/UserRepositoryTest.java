package com.example.be_java_hisp_w15_g07.unit.repository;

import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.repository.UserRepository;
import com.example.be_java_hisp_w15_g07.utils.InitDatabase;
import com.example.be_java_hisp_w15_g07.utils.PostFactory;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRepositoryTest {

    private IUserRepository repository;

    private Map<Integer, User> database;

    @BeforeEach
    public void setup(){
        this.repository = new UserRepository();
        this.database = new HashMap<>();
        InitDatabase.initDatabase(database);
    }

    @Test
    @DisplayName("T0001/02 - Verificar que el usuario a seguir existe")
    public void findUserSuccess(){
        // Arrange
        Integer queryId = 1;

        // Act
        User result = repository.findById(queryId);

        // Assert
        assertEquals(1, result.getUserId());
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

    @Test
    @DisplayName("BONUS - Verificar que se crea un nuevo post correctamente")
    public void createNewPostSuccess(){
        // Arrange
        Integer userId = 2;

        Post post = PostFactory.getNewPost();
        database.get(userId).newPost(post);
        List<Post> expected = database.get(userId).getPosts();

        // Act
        repository.newPost(userId, post);
        List<Post> result = repository.findById(userId).getPosts();

        // Assert
        assertEquals(expected, result);
    }
}
