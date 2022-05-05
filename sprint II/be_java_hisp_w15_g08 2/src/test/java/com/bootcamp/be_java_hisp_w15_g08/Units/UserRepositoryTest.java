package com.bootcamp.be_java_hisp_w15_g08.Units;

import com.bootcamp.be_java_hisp_w15_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class UserRepositoryTest {

    @Mock
    IUserRepository repository;

    @Test
    @DisplayName(" encontramos al usuario si existe y lo retornamos")
    void VerifyThatUserExistAndReturn(){
        //Arrange
        User esperado = new User();
        esperado.setUserID(1234); //El id debe ya estar registrado en el repositorio
        esperado.setName("Marcelo");
        //Act
        User resultado= repository.findUser(esperado.getUserID());
        //Assert
        Assertions.assertEquals(esperado.getUserID(),resultado.getUserID());

    }

    @Test
    void VerifyThatUserDoesntExistAndThrowException(){
        //Arrange
        User esperado = new User();
        esperado.setUserID(1); // un id de un usuario que no exista
        //Act+Assert
        Assertions.assertThrows(UserNotFoundException.class , ()->repository.findUser(esperado.getUserID()));

    }

//Los test a continuacion son redundantes porque probamos solo el findUserbyid

    //Verificar que el usuario a dejar de seguir exista. (US-0007)
    @Test
    void VerifythatUserToUnfollowExist(){
        User esperado = new User();
        esperado.setUserID(1234); //El id debe ya estar registrado en el repositorio
        esperado.setName("Marcelo");
        //Act
        User resultado= repository.findUser(esperado.getUserID());
        //Assert
        Assertions.assertEquals(esperado.getUserID(),resultado.getUserID());

    }

    @Test
    void VerifyThatUserToUnfollowDoesntExistAndThrowException(){
        //Arrange
        User esperado = new User();
        esperado.setUserID(1); // un id de un usuario que no exista
        //Act+Assert
        Assertions.assertThrows(UserNotFoundException.class , ()->repository.findUser(esperado.getUserID()));

    }

}
