package com.sprint1.be_java_hisp_w15_g4.unit;

import com.sprint1.be_java_hisp_w15_g4.dto.response.PostListDTO;
import com.sprint1.be_java_hisp_w15_g4.exception.BadOrderArgumentExcepcion;
import com.sprint1.be_java_hisp_w15_g4.exception.IDNotFoundException;
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
public class T0005 {

    @Mock
    private IUserRepository repo;

    @InjectMocks
    private ProductService service;

    @Test
    @DisplayName("Se verifica que el ordenamiento ascendente por fecha exista")
    void verificarOrdenamientoPorFechaAscendente(){
        //Arrange

        //Creo un nuevo usuario
        int userId1 = 1;
        User user = new User(userId1, "nombre1");

        //Mock
        Mockito.when(repo.findUser(userId1)).thenReturn(user);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> service.lastTwoWeeksPosts(user.getUser_id(), "date_asc"));
    }

    @Test
    @DisplayName("Se verifica que el ordenamiento descendente por fecha exista")
    void verificarOrdenamientoPorFechaDescendiente(){
        //Arrange

        //Creo un nuevo usuario
        int userId2 = 2;
        User user = new User(userId2, "nombre2");

        //Mock
        Mockito.when(repo.findUser(userId2)).thenReturn(user);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> service.lastTwoWeeksPosts(user.getUser_id(), "date_desc"));
    }

    @Test
    @DisplayName("Se verifica que el ordenamiento por fecha con null como parámetro exista")
    void verificarOrdenamientoConParametroNull(){
        //Arrange

        //Creo un nuevo usuario
        int userId4 = 4;
        User user = new User(userId4, "nombre4");

        //Mock
        Mockito.when(repo.findUser(userId4)).thenReturn(user);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> service.lastTwoWeeksPosts(user.getUser_id(), null));
    }

    @Test
    @DisplayName("Ese tipo de ordenamiento por fecha no existe")
    void ordenamientoLanzaExcepcion(){
        //Arrange

        //Creo un nuevo usuario
        int userId3 = 3;
        User user = new User(userId3, "nombre3");

        //Mock
        Mockito.when(repo.findUser(userId3)).thenReturn(user);

        //Act & Assert
        Assertions.assertThrows(BadOrderArgumentExcepcion.class, () -> service.lastTwoWeeksPosts(user.getUser_id(), "no_existo"));
    }

}
