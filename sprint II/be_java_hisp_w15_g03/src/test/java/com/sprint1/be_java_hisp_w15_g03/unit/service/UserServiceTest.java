package com.sprint1.be_java_hisp_w15_g03.unit.service;

import com.sprint1.be_java_hisp_w15_g03.exception.PersonNotFoundException;
import com.sprint1.be_java_hisp_w15_g03.exception.RelationConflictException;
import com.sprint1.be_java_hisp_w15_g03.repository.IMeliRepository;
import com.sprint1.be_java_hisp_w15_g03.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IMeliRepository meliRepository;

    @InjectMocks
    UserService userService;

    //T-0001
    @Test
    @DisplayName("Seguir a un vendedor correctamente.")
    void followSeller(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(false);

        //Act
        userService.followSeller(1, 1);

        //Assert
        verify(meliRepository, atLeastOnce()).followSeller(anyInt(), anyInt());
    }

    //T-0001
    @Test
    @DisplayName("Se intenta seguir a un vendedor con un usuario inexistente: PersonNotFoundException")
    void followSellerUserNotFoundException(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(false);

        //Act Assert
        Assertions.assertThrows(PersonNotFoundException.class,
                () -> userService.followSeller(1, 1));
    }

    //T-0001
    @Test
    @DisplayName("Se intenta seguir a un vendedor inexistente: PersonNotFoundException")
    void followSellerSellerNotFoundException(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(false);

        //Act Assert
        Assertions.assertThrows(PersonNotFoundException.class,
                () -> userService.followSeller(1, 1));
    }

    //T-0001
    @Test
    @DisplayName("Se intenta seguir a un vendedor al cual ya se sigue: RelationConflictException")
    void followSellerRelationConflictException(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(true);

        //Act Assert
        Assertions.assertThrows(RelationConflictException.class,
                () -> userService.followSeller(1, 1));
    }

    //T-0002
    @Test
    @DisplayName("Se deja de seguir a un vendedor correctamente")
    void unFollowSeller(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(true);

        //Act
        userService.unFollowSeller(1, 1);

        //Assert
        verify(meliRepository, atLeastOnce()).unFollowSeller(anyInt(), anyInt());
    }

    //T-0002
    @Test
    @DisplayName("Se intenta dejar de seguir a un vendedor con un usuario inexistente: PersonNotFoundException")
    void unFollowSellerUserNotFoundException(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(false);

        //Act Assert
        Assertions.assertThrows(PersonNotFoundException.class,
                () -> userService.unFollowSeller(1, 1));
    }

    //T-0002
    @Test
    @DisplayName("Se intenta dejar de seguir a un vendedor con un vendedor inexistente: PersonNotFoundException")
    void unFollowSellerSellerNotFoundException(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(false);

        //Act Assert
        Assertions.assertThrows(PersonNotFoundException.class,
                () -> userService.unFollowSeller(1, 1));
    }

    //T-0002
    @Test
    @DisplayName("Se intenta dejar de seguir a un vendedor que no se seguía: RelationConflictException")
    void unFollowSellerRelationConflictException(){
        //Arrange
        when(meliRepository.hasUser(anyInt())).thenReturn(true);
        when(meliRepository.hasSeller(anyInt())).thenReturn(true);
        when(meliRepository.following(anyInt(), anyInt())).thenReturn(false);

        //Act Assert
        Assertions.assertThrows(RelationConflictException.class,
                () -> userService.unFollowSeller(1, 1));
    }
}
