package com.sprint2.be_java_hisp_w15_g4.unit;

import Utils.TestGenerator;
import com.sprint2.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint2.be_java_hisp_w15_g4.exception.IDNotFoundException;
import com.sprint2.be_java_hisp_w15_g4.model.User;
import com.sprint2.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint2.be_java_hisp_w15_g4.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class T0007 {
    @Mock
    private IUserRepository repo;

    @InjectMocks
    private UserService service;

    @Test
    @DisplayName("Verificar si el calculo de la cantidad de seguidores de un usuario es correcta.")
    void verificarCantidadSeguidoresOK() {
        // Arrange
        User user = TestGenerator.userWithFollowers();

        FollowerCountDTO seguidoresUser=
                new FollowerCountDTO(user.getUser_id(),user.getUser_name(),user.getFollowers().size());

        // Mock
        Mockito.when(repo.findUser(Mockito.anyInt())).thenReturn(user);

        // Act
        /* Ejecuto el metodo para obtener el DTO del service */
        FollowerCountDTO resultFolowers = service.countFollowers(user.getUser_id());
        // Assert
        /*
        * Verifico si la cantidad de seguidores del resultado es la misma que la creada
        * Verifico que la cantidad de seguidores sea 3
        * Verifico que la cantidad de seguidores sea distinto de 0
        * */
        Assertions.assertAll(
                () -> Assertions.assertEquals(seguidoresUser.getFollowers_count(),resultFolowers.getFollowers_count()),
                () -> Assertions.assertEquals(3,resultFolowers.getFollowers_count()),
                () -> Assertions.assertTrue(resultFolowers.getFollowers_count()!=0)
        );
    }

    @Test
    @DisplayName("Verificar si lanza excepcion al pasarle un usuario que no existe.")
    void verificarCantidadSeguidoresNotOK() {
        // Mock
        Mockito.when(repo.findUser(Mockito.anyInt())).thenReturn(null);
        // Act && Assert
        Assertions.assertThrows(IDNotFoundException.class, () -> service.countFollowers(Mockito.anyInt()));
    }
}
