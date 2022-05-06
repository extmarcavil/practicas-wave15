package com.sprint.be_java_hisp_w15_g10.unit.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    /**
     * Valida que dado un id valido, se obtenga un usuario con ese id
     *
     */
    @Test
    @DisplayName("Test usuario valido por id")
    void getValidUserById() {
        // arrange
        User user_followed = TestUtils.createFollowedUser(userRepository);

        //act
        Optional<User> user = userRepository.getById(4);

        // assert
        Assertions.assertAll(
                () -> Assertions.assertEquals("Luis", user.get().getUser_name()),
                () -> Assertions.assertEquals(user.get(), user_followed),
                () -> Assertions.assertEquals(user.get().getFollowed(), user_followed.getFollowed())
        );
    }

    /**
     * Valida que dado un id invalido,no haya un usuario con ese id
     *
     */
    @Test
    @DisplayName("Test usuario invalido por id")
    void getInvalidUserById() {
        // arrange
        TestUtils.createFollowedUser(userRepository);

        //act
        Optional<User> user = userRepository.getById(10);

        // assert
        Assertions.assertTrue(user.isEmpty());
    }

    /**
     * Validaque se puedan obtener todos los usuarios
     *
     */
    @Test
    @DisplayName("Test de obtener todos los usuarios")
    void getAll() {
        // arrange
        TestUtils.createFollowedUser(userRepository);

        //act
        List<User> users = userRepository.getAll();

        // assert
        Assertions.assertAll(
                () -> {
                    Assertions.assertFalse(users.isEmpty());
                },
                () -> {
                    Assertions.assertEquals(users.size(), 7);
                }
        );
    }


    /**
     * Valida que se pueda crear un usuario y que se pueda agregar al repositorio
     *
     */
    @Test
    @DisplayName("Test de agregar un usuario")
    void add() {
        // arrange
        User user = new User(4, "José");
        int initial_size = userRepository.getAll().size();
        // act
        userRepository.add(user);
        int final_size = userRepository.getAll().size();
        // assert
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(initial_size + 1, final_size);
                },
                () -> {
                    Assertions.assertEquals(user, userRepository.getById(4).get());
                }
        );
    }
}