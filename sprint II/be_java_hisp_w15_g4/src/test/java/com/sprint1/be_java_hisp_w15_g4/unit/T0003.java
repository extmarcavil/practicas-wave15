package com.sprint1.be_java_hisp_w15_g4.unit;

import Utils.TestGenerator;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.exception.BadOrderArgumentExcepcion;
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

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class T0003 {
    @Mock
    private IUserRepository repo;

    @InjectMocks
    private UserService service;

    @Test
    @DisplayName("Verifica que name_asc es un ordenamiento correcto de la lista de seguidores.")
    void orderFollowersNameAscOk(){

        //arrange
        //ordenamiento correcto.
        String order="name_asc";

        User user = TestGenerator.userWithFollowers();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act & assert
        Assertions.assertDoesNotThrow(
                ()->service.listFollowers(1,order)
        );
    }

    @Test
    @DisplayName("Verifica que name_desc es un ordenamiento correcto de la lista de seguidores.")
    void orderFollowersNameDescOk(){

        //arrange
        //ordenamiento correcto.
        String order="name_desc";

        User user = TestGenerator.userWithFollowers();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act & assert
        Assertions.assertDoesNotThrow(
                ()->service.listFollowers(1,order)
        );
    }


    @Test
    @DisplayName("Verifica que se lanza una Excepcion al ingresar un ordenamiento incorrecto de la lista de Followers")
    void orderFollowersNotOk(){

        //arrange

        User user = TestGenerator.userWithFollowers();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act & assert
        Assertions.assertThrows(
                BadOrderArgumentExcepcion.class,
                ()->service.listFollowers(1,Mockito.anyString())
        );
    }

    //following

    @Test
    @DisplayName("Verifica que name_asc es un ordenamiento correcto de la lista de seguidos.")
    void orderFollowingNameAscOk(){
        //arrange
        //ordenamiento correcto.
        String order="name_asc";

        User user = TestGenerator.userWithFollowings();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act & assert
        Assertions.assertDoesNotThrow(
                ()->service.listFollowing(1,order)
        );
    }

    @Test
    @DisplayName("Verifica que name_asc es un ordenamiento correcto de la lista de seguidos.")
    void orderFollowingsNameDescOk(){

        //arrange
        //ordenamiento correcto.
        String order="name_desc";

        User user = TestGenerator.userWithFollowings();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        Assertions.assertDoesNotThrow(
                ()->service.listFollowing(1,order)
        );
    }


    @Test
    @DisplayName("Verifica que se lanza una Excepcion al ingresar un ordenamiento incorrecto de la lista de Seguidos")
    void orderFollowingsNotOk(){

        //arrange
        User user = TestGenerator.userWithFollowings();

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act & assert
        Assertions.assertThrows(
                BadOrderArgumentExcepcion.class,
                ()->service.listFollowing(1,Mockito.anyString())
        );
    }
}
