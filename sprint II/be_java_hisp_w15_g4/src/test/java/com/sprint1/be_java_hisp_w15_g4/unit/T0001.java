package com.sprint1.be_java_hisp_w15_g4.unit;

import com.sprint1.be_java_hisp_w15_g4.exception.IDNotFoundException;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint1.be_java_hisp_w15_g4.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class T0001 {
    @Mock
    private IUserRepository repo;

    @InjectMocks
    private UserService service;

    @Test
    @DisplayName("Permite continuar con normalidad")
    void verificarFollowExistOK() {
        // Arrange
        int userId1 = 1;
        int userId2 = 2;

        User user = new User(userId1, "nombre1");
        User user2 = new User(userId2, "nombre2");

        // Mock
        Mockito.when(repo.findUser(userId1)).thenReturn(user);
        Mockito.when(repo.findUser(userId2)).thenReturn(user2);

        // Act
        service.follow(1,2);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(user.getFollowing().contains(user2)),
                () -> Assertions.assertTrue(user2.getFollowers().contains(user))
        );
    }

    @Test
    @DisplayName("Notifica la no existencia mediante una excepción")
    void verificarFollowNotExistOK() {
        // Arrange
        int userId1 = 1;

        User user = new User(userId1, "nombre1");

        // Mock
        Mockito.when(repo.findUser(userId1)).thenReturn(user);

        // Act & Assert
        Assertions.assertThrows(IDNotFoundException.class, () -> service.follow(1,2));
    }
}
