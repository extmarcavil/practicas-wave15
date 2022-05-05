package com.example.be_java_hisp_w15_g07.unit.repository;

import com.example.be_java_hisp_w15_g07.exception.UserNotFoundException;
import com.example.be_java_hisp_w15_g07.model.User;
import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import com.example.be_java_hisp_w15_g07.repository.UserRepository;
import com.example.be_java_hisp_w15_g07.utils.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    private IUserRepository repository;

    @BeforeEach
    public void setup(){
        repository = new UserRepository();
    }

    @Test
    @DisplayName("T00001/02 - Verificar que el usuario a seguir exista")
    public void findExistingUser(){
        //arrange
        Integer queryId = 1;
        User expected = UserFactory.getUserOne();

        //act
        User result = repository.findById(queryId);

        //assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0001/02 - Verificar que si el usuario a seguir no existe, lanza excepción")
    public void throwsExceptionWhenUserNotFound(){
        //arrange
        Integer queryId = -1; //IDs are always positive

        //act and assert
        assertThrows(UserNotFoundException.class, () -> repository.findById(queryId));
    }
}
