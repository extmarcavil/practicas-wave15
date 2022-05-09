package com.example.be_java_hisp_w15_g07.unit.service;

import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.service.UserService;
import com.example.be_java_hisp_w15_g07.utils.InitDatabase;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private Map<Integer, User> database;

    @Mock
    private IUserRepository repository;

    @InjectMocks
    private UserService service;

    @BeforeEach
    public void setup(){
        this.database = new HashMap<>();
        InitDatabase.initDatabase(database);
    }

    @Test
    @DisplayName("T0001 - Verificar que el usuario a seguir existe")
    public void findUserSuccess(){
        // Arrange
        Integer userId = 4;
        Integer queryId = 2;
        User user4 = UserFactory.getUserFour();
        User user2 = UserFactory.getUserTwo();

        // Mock
        when(repository.findById(userId)).thenReturn(user4);
        when(repository.findById(queryId)).thenReturn(user2);

        // Act and assert
        assertDoesNotThrow(() -> service.followUser(userId, queryId));
        verify(repository, times(2)).findById(anyInt());
    }

    @Test
    @DisplayName("T0001 - Verificar que se lanza una excepción si el usuario a seguir no existe")
    public void findUserNotFound(){
        // Arrange
        Integer userId = 1;
        Integer queryId = -2;
        User user1 = UserFactory.getUserOne();

        // Mock
        when(repository.findById(userId)).thenReturn(user1);
        when(repository.findById(queryId)).thenThrow(UserNotFoundException.class);

        // Act and assert
        try {
            service.followUser(userId, queryId);
        } catch (UserNotFoundException e){
            verify(repository, times(2)).findById(anyInt());
        }
    }


    @Test
    @DisplayName("T0001 - Verificar que se lanza una excepción si el usuario a seguir no es vendedor")
    public void followUserNotSellerBadRequest(){
        // Arrange
        Integer userId = 2;
        Integer queryId = 1;
        String exceptionMessage = "No se puede seguir un usuario que no es vendedor.";

        // Mock
        when(repository.findById(userId)).thenReturn(database.get(userId));
        when(repository.findById(queryId)).thenReturn(database.get(queryId));

        // Act and assert
        BadRequestException exception = assertThrows(
                BadRequestException.class, () -> service.followUser(userId, queryId));

        assertAll(
                () -> assertEquals(exceptionMessage, exception.getMessage()),
                () -> verify(repository, times(1)).findById(userId),
                () -> verify(repository, times(1)).findById(queryId)
        );
    }


    @Test
    @DisplayName("T0001 - Verificar que se lanza una excepción si el usuario se quiere seguir a si mismo")
    public void followUserSelfBadRequest(){
        // Arrange
        Integer userId = 2;
        String exceptionMessage = "No se puede seguir a si mismo.";

        // Mock
        when(repository.findById(userId)).thenReturn(database.get(userId));

        // Act and assert
        BadRequestException exception = assertThrows(
                BadRequestException.class, () -> service.followUser(userId, userId));

        assertAll(
                () -> assertEquals(exceptionMessage, exception.getMessage()),
                () -> verify(repository, times(2)).findById(userId)
        );
    }

    @Test
    @DisplayName("T0001 - Verificar que se lanza una excepción si el usuario ya sigue al vendedor")
    public void followUserAlreadyFollowedBadRequest(){
        // Arrange
        Integer userId = 3;
        Integer queryId = 2;
        String exceptionMessage = "Ya estas siguiendo a este usuario.";

        // Mock
        when(repository.findById(userId)).thenReturn(database.get(userId));
        when(repository.findById(queryId)).thenReturn(database.get(queryId));

        // Act and assert
        BadRequestException exception = assertThrows(
                BadRequestException.class, () -> service.followUser(userId, queryId));

        assertAll(
                () -> assertEquals(exceptionMessage, exception.getMessage()),
                () -> verify(repository, times(1)).findById(userId),
                () -> verify(repository, times(1)).findById(queryId)
        );
    }

    @Test
    @DisplayName("T0002 - Verificar que el usuario a dejar de seguir existe")
    public void findUserToUnfollowSuccess(){
        // Arrange
        Integer userId = 1;
        Integer queryId = 2;
        User user1 = UserFactory.getUserOne();
        User user2 = UserFactory.getUserTwo();
        UserFactory.setFollowedList(user1, user2);

        // Mock
        when(repository.findById(userId)).thenReturn(user1);
        when(repository.findById(queryId)).thenReturn(user2);

        // Act and assert
        assertDoesNotThrow(() -> service.unfollowUser(userId, queryId));
        verify(repository, times(2)).findById(anyInt());
    }

    @Test
    @DisplayName("T0002 - Verificar que se lanza una excepción si el usuario a dejar de seguir no existe")
    public void findUserToUnfollowNotFound(){
        // Arrange
        Integer userId = 1;
        Integer queryId = -2;
        User user1 = UserFactory.getUserOne();

        // Mock
        when(repository.findById(userId)).thenReturn(user1);
        when(repository.findById(queryId)).thenThrow(UserNotFoundException.class);

        // Act and assert
        try{
            service.unfollowUser(userId, queryId);
        } catch (UserNotFoundException e){
            verify(repository, times(2)).findById(anyInt());
        }
    }


    @Test
    @DisplayName("T0002 - Verificar que se lanza una excepción si el usuario se quiere dejar de seguir a si mismo")
    public void unfollowUserSelfBadRequest(){
        // Arrange
        Integer userId = 2;
        String exceptionMessage = "No se puede dejar de seguir a si mismo.";

        // Mock
        when(repository.findById(userId)).thenReturn(database.get(userId));

        // Act and assert
        BadRequestException exception = assertThrows(
                BadRequestException.class, () -> service.unfollowUser(userId, userId));

        assertAll(
                () -> assertEquals(exceptionMessage, exception.getMessage()),
                () -> verify(repository, times(2)).findById(userId)
        );
    }

    @Test
    @DisplayName("T0002 - Verificar que se lanza una excepción si el usuario quiere dejar de seguir a alguien que no " +
            "sigue")
    public void unfollowUserNotFollowedBadRequest(){
        // Arrange
        Integer userId = 2;
        Integer queryId = 1;
        String exceptionMessage = "Este usuario no sigue a este vendedor.";

        // Mock
        when(repository.findById(userId)).thenReturn(database.get(userId));
        when(repository.findById(queryId)).thenReturn(database.get(queryId));

        // Act and assert
        BadRequestException exception = assertThrows(
                BadRequestException.class, () -> service.unfollowUser(userId, queryId));

        assertAll(
                () -> assertEquals(exceptionMessage, exception.getMessage()),
                () -> verify(repository, times(1)).findById(userId),
                () -> verify(repository, times(1)).findById(queryId)
        );
    }

    @Test
    @DisplayName("T0003 - (Followers) Verificar que el tipo de ordenamiento alfabético ascendente existe")
    public void findFollowersOrderByNameAscExists(){
        // Arrange
        Integer userId = 2;
        String order = "name_asc";
        List<User> followers = Arrays.asList(UserFactory.getUserOne(), UserFactory.getUserThree());

        // Mock
        when(repository.findFollowersOrderByNameAsc(userId)).thenReturn(followers);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(1)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act and Assert
        assertDoesNotThrow(() -> service.getFollowersList(userId, order));
    }

    @Test
    @DisplayName("T0003 - (Followers) Verificar que el tipo de ordenamiento alfabético descendente existe")
    public void findFollowersOrderByNameDescExists(){
        // Arrange
        Integer userId = 2;
        String order = "name_desc";
        List<User> followers = Arrays.asList(UserFactory.getUserThree(), UserFactory.getUserOne());

        // Mock
        when(repository.findFollowersOrderByNameDesc(userId)).thenReturn(followers);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(1)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act and Assert
        assertDoesNotThrow(() -> service.getFollowersList(userId, order));
    }

    @Test
    @DisplayName("T0003 - (Followed) Verificar que el tipo de ordenamiento alfabético ascendente existe")
    public void findFollowedOrderByNameAscExists(){
        // Arrange
        Integer userId = 1;
        String order = "name_asc";
        List<User> followed = Arrays.asList(UserFactory.getUserTwo(), UserFactory.getUserThree());

        // Mock
        when(repository.findFollowedOrderByNameAsc(userId)).thenReturn(followed);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(2)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act and Assert
        assertDoesNotThrow(() -> service.getFollowedList(userId, order));
    }

    @Test
    @DisplayName("T0003 - (Followed) Verificar que el tipo de ordenamiento alfabético descendente existe")
    public void findFollowedOrderByNameDescExists(){
        // Arrange
        Integer userId = 1;
        String order = "name_desc";
        List<User> followed = Arrays.asList(UserFactory.getUserThree(), UserFactory.getUserTwo());

        // Mock
        when(repository.findFollowedOrderByNameDesc(userId)).thenReturn(followed);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());
        when(repository.findById(2)).thenReturn(UserFactory.getUserTwo());

        // Act and Assert
        assertDoesNotThrow(() -> service.getFollowedList(userId, order));
    }


    @Test
    @DisplayName("T0003 - (Followers) Verificar que se lanza una excepción cuando el tipo de ordenamiento no existe")
    public void findFollowersOrderByNameBadRequest(){
        // Arrange
        Integer userId = 1;
        String order = "Otro ordenamiento";

        // Act and assert
        assertThrows(BadRequestException.class, () -> service.getFollowersList(userId, order));
    }

    @Test
    @DisplayName("T0003 - (Followed) Verificar que se lanza una excepción cuando el tipo de ordenamiento no existe")
    public void findFollowedOrderByNameBadRequest(){
        // Arrange
        Integer userId = 1;
        String order = "Otro ordenamiento";

        // Act and assert
        assertThrows(BadRequestException.class, () -> service.getFollowedList(userId, order));
    }

    @Test
    @DisplayName("T0004 - (Followers) Verificar el correcto ordenamiento alfabético ascendente por nombre")
    public void findFollowersOrderByNameAscSuccess(){
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
    @DisplayName("T0004 - (Followers) Verificar el correcto ordenamiento alfabético descendente por nombre")
    public void findFollowersOrderByNameDescSuccess(){
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
    @DisplayName("T0004 - (Followed) Verificar el correcto ordenamiento alfabético ascendente por nombre")
    public void findFollowedOrderByNameAscSuccess(){
        // Arrange
        Integer userId = 1;
        String order = "name_asc";
        List<User> followers = Arrays.asList(UserFactory.getUserTwo(), UserFactory.getUserThree());
        FollowedDTO expected = UserFactory.getFollowedDTOAsc();

        // Mock
        when(repository.findFollowedOrderByNameAsc(userId)).thenReturn(followers);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(2)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act
        FollowedDTO result = service.getFollowedList(userId, order);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0004 - (Followers) Verificar el correcto ordenamiento alfabético descendente por nombre")
    public void findFollowedOrderByNameDescSuccess(){
        // Arrange
        Integer userId = 1;
        String order = "name_desc";
        List<User> followed = Arrays.asList(UserFactory.getUserThree(), UserFactory.getUserTwo());
        FollowedDTO expected = UserFactory.getFollowedDTODesc();

        // Mock
        when(repository.findFollowedOrderByNameDesc(userId)).thenReturn(followed);
        when(repository.findById(userId)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());
        when(repository.findById(2)).thenReturn(UserFactory.getUserTwo());

        // Act
        FollowedDTO result = service.getFollowedList(userId, order);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0007 - Verificar que la cantidad de seguidores de un determinado usuario sea correcta")
    public void returnsCorrectFollowersCount(){
        // Arrange
        Integer userId = 2;
        User user2 = UserFactory.getUserTwo();

        int expectedFollowersCount = 2;

        // Mock
        when(repository.findById(userId)).thenReturn(user2);

        // Act
        FollowersCountDTO result = service.followersCount(user2.getUserId());

        // Assert
        assertEquals(2, result.getFollowersCount());
    }

    @Test
    @DisplayName("T0007 - Verificar que la cantidad de seguidores de un determinado usuario sea 0")
    public void returnsCorrectFollowersCount0(){
        // Arrange
        Integer userId = 1;
        User user1 = UserFactory.getUserOne();

        int expectedFollowersCount = 0;

        // Mock
        when(repository.findById(userId)).thenReturn(user1);

        // Act
        FollowersCountDTO result = service.followersCount(user1.getUserId());

        // Assert
        assertEquals(expectedFollowersCount, result.getFollowersCount());
    }

    @Test
    @DisplayName("BONUS - Verificar que se retorna correctamente la lista de seguidores sin especificar ordenamiento")
    public void getFollowersListSuccess(){
        // Arrange
        Integer userId = 2;
        FollowersDTO expected = UserFactory.getFollowersDTOAsc();

        // Mock
        when(repository.findById(userId)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(1)).thenReturn(UserFactory.getUserOne());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act
        FollowersDTO result = service.getFollowersList(userId);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("BONUS - Verificar que se retorna correctamente la lista de seguidos sin especificar ordenamiento")
    public void getFollowedListSuccess(){
        // Arrange
        Integer userId = 1;
        FollowedDTO expected = UserFactory.getFollowedDTOAsc();

        // Mock
        when(repository.findById(userId)).thenReturn(UserFactory.getUserOneWithFollowed());
        when(repository.findById(2)).thenReturn(UserFactory.getUserTwo());
        when(repository.findById(3)).thenReturn(UserFactory.getUserThree());

        // Act
        FollowedDTO result = service.getFollowedList(userId);

        // Assert
        assertEquals(expected, result);
    }
}
