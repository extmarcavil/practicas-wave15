package com.sprint1.be_java_hisp_w15_g4.unit;

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
    void ordenamientoFollowersNameAscOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String ordenamiento="name_asc";

        User user = new User(userId1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        service.listFollowers(1,ordenamiento);
    }

    @Test
    @DisplayName("Verifica que name_desc es un ordenamiento correcto de la lista de seguidores.")
    void ordenamientoFollowersNameDescOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String ordenamiento="name_desc";

        User user = new User(userId1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        service.listFollowers(1,ordenamiento);
    }


    @Test
    @DisplayName("Verifica que se lanza una Excepcion al ingresar un ordenamiento incorrecto de la lista de Followers")
    void ordenamientoFollowersNotOk(){

        //arrange
        int userId1 = 1;

        User user = new User(userId1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));

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
    void ordenamientoFollowingNameAscOk(){
        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String ordenamiento="name_asc";

        User user = new User(userId1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        service.listFollowing(1,ordenamiento);
    }

    @Test
    @DisplayName("Verifica que name_asc es un ordenamiento correcto de la lista de seguidos.")
    void ordenamientoFollowingsNameDescOk(){

        //arrange
        int userId1 = 1;
        //ordenamiento correcto.
        String ordenamiento="name_desc";

        User user = new User(userId1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act
        service.listFollowing(1,ordenamiento);
    }


    @Test
    @DisplayName("Verifica que se lanza una Excepcion al ingresar un ordenamiento incorrecto de la lista de followings")
    void ordenamientoFollowingsNotOk(){

        //arrange
        int userId1 = 1;

        User user = new User(userId1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "lombre2");
        User user4 = new User(4, "aombre2");

        user.setFollowers(List.of(
                user2,
                user3,
                user4
        ));

        Mockito.when(repo.findUser(1)).thenReturn(user);

        //act & assert
        Assertions.assertThrows(
                BadOrderArgumentExcepcion.class,
                ()->service.listFollowing(1,Mockito.anyString())
        );
    }




}
