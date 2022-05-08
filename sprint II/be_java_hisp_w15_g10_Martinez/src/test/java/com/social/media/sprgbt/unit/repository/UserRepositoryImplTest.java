package com.social.media.sprgbt.unit.repository;

import com.social.media.sprgbt.entity.User;
import com.social.media.sprgbt.repository.IUserRepository;
import com.social.media.sprgbt.repository.impl.UserRepositoryImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {


    /**
     * Instancia de la clase a testear UserRepositoryImpl
     */
    private IUserRepository userRepositoryImpl;


    @BeforeEach
    void setUp() {
        userRepositoryImpl = new UserRepositoryImpl();
        UserRepositoryImpl.listUsers = new ArrayList<>();
        UserRepositoryImpl.count = new AtomicInteger(0);
    }


    @Test
    @DisplayName("Test creando un Usuario")
    void createUserTest() {
        //Arrange
        User juan = Data.USER_JUAN;

        //Act
        User result = userRepositoryImpl.createUser(juan);

        //Assert
        assertAll(
                () -> assertTrue(result != null),
                () -> assertEquals("Juan", result.getUserName()),
                () -> assertEquals(1, result.getUserId())
        );
    }


    @Test
    @DisplayName("Test Obteniendo la lista de Users")
    void getAllUsersTest() {
        //Arrange
        User juan = Data.USER_JUAN;
        User pedro = Data.USER_PEDRO;
        User felipe = Data.USER_FELIPE;

        User result1 = userRepositoryImpl.createUser(juan);
        User result2 = userRepositoryImpl.createUser(pedro);
        User result3 = userRepositoryImpl.createUser(felipe);

        //Act
        List<User> usersList = userRepositoryImpl.getAllUsers();

        //Assert
        assertAll(
                () -> assertNotNull(usersList),
                () -> assertEquals(3, usersList.size()),
                () -> assertEquals("Pedro", usersList.get(1).getUserName())
        );
    }

    @Test
    @DisplayName("Test obtener usuario por Name")
    void getUserByUserNameTest() {
        //Arrange
        User juan = Data.USER_JUAN;
        User result1 = userRepositoryImpl.createUser(juan);

        //Act
        User getUser = userRepositoryImpl.getUserByUsername("Juan");

        //Assert
        assertAll(
                () -> assertNotNull(getUser),
                () -> assertEquals(1, getUser.getUserId()),
                () -> assertEquals("Juan", getUser.getUserName())
        );

    }

    @Test
    @DisplayName("Test obtener un User por Name no almacenado en la BD")
    void getUserByUserNameNotFound() {
        //Arrange
        User juan = Data.USER_JUAN;

        //Act
        User getUser = userRepositoryImpl.getUserByUsername("Juan");

        //Assert
        assertNull(getUser);

    }

    @Test
    @DisplayName("Test obtener usuario por Id")
    void getUserByUserIdTest() {
        //Arrange
        User juan = Data.USER_JUAN;
        User result1 = userRepositoryImpl.createUser(juan);

        //Act
        User getUser = userRepositoryImpl.getUserById(1);

        //Assert
        assertAll(
                () -> assertNotNull(getUser),
                () -> assertEquals(1, getUser.getUserId()),
                () -> assertEquals("Juan", getUser.getUserName())
        );

    }

    @Test
    @DisplayName("Test obtener un User por Id no almacenado en la BD")
    void getUserByUserIdNotFound() {
        //Arrange
        User juan = Data.USER_JUAN;

        //Act
        User getUser = userRepositoryImpl.getUserById(1);

        //Assert
        assertNull(getUser);

    }
}