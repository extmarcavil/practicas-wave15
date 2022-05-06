package com.sprint1.be_java_hisp_w15_g4.unit;

import Utils.TestGenerator;
import com.sprint1.be_java_hisp_w15_g4.exception.AlreadyFollowing;
import com.sprint1.be_java_hisp_w15_g4.exception.EqualsIDException;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint1.be_java_hisp_w15_g4.service.ProductService;
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
public class T0010 {
    @Mock
    private IUserRepository repo;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Verifico seguir a alguien que ya estoy siguiendo y si tira excepcion")
    void verifyFollowWithAlReadyFollowing() {
        // Arrange
        int userId3 = 3;
        int userId4 = 4;

        User user3 = TestGenerator.GenerateUser(userId3,"nombre3");
        User user4 = TestGenerator.GenerateUser(userId4,"nombre4");
        user3.addFollowing(user4);
        user4.addFollower(user3);
        // Mock
        Mockito.when(repo.findUser(userId3)).thenReturn(user3);
        Mockito.when(repo.findUser(userId4)).thenReturn(user4);

        // Act & Assert
        Assertions.assertThrows(AlreadyFollowing.class, () -> userService.follow(3,4));
    }

    @Test
    @DisplayName("Verifico si al seguirse a si mismo tira excepcion")
    void verifyFollowWithEqualsIDExceptionFollowing() {
        // Act & Assert
        Assertions.assertThrows(EqualsIDException.class, () -> userService.unfollow(3,3));
    }


}
