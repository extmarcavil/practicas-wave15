package com.sprint1.be_java_hisp_w15_g4.unit;

import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
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
public class T0007 {
    @Mock
    private IUserRepository repo;

    @InjectMocks
    private UserService service;

    @Test
    @DisplayName("Verificar si el calculo de la cantidad de seguidores de un usuario es correcta.")
    void verificarCantidadSeguidoresOK() {
        // Arrange
        User user1 = new User(1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "nombre3");

        /* Usuario 1 y 3 siguien al usuario 2 */
        user1.addFollowing(user2);//user siguiendo al 2
        user3.addFollowing(user2);//user3 siguiendo al 2
        /* Usuario 2 es seguido por el usuario 1 y 3 */
        user2.addFollower(user1);//user 2 lo sigue 1
        user2.addFollower(user3);//user 2 lo sigue 3
        /* Obtengo el DTO con los seguidores del Usuario 2 */
        FollowerCountDTO seguidoresUser2=
                new FollowerCountDTO(user2.getUser_id(),user2.getUser_name(),user2.getFollowers().size());

        // Mock
        Mockito.when(repo.findUser(Mockito.anyInt())).thenReturn(user2);

        // Act
        /* Ejecuto el metodo para obtener el DTO del service */
        FollowerCountDTO resultFolowers = service.countFollowers(user2.getUser_id());
        // Assert
        /*
        * Verifico si la cantidad de seguidores del resultado es la misma que la creada
        * Verifico que la cantidad de seguidores sea 2
        * Verifico que la cantidad de seguidores sea distinto de 0
        * */
        Assertions.assertAll(
                () -> Assertions.assertEquals(seguidoresUser2.getFollowers_count(),resultFolowers.getFollowers_count()),
                () -> Assertions.assertEquals(2,resultFolowers.getFollowers_count()),
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
