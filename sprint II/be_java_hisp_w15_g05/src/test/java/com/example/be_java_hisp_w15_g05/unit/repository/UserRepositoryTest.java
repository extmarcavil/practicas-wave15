package com.example.be_java_hisp_w15_g05.unit.repository;

import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import com.example.be_java_hisp_w15_g05.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    IUserRepository repository;

    @BeforeEach
    void setup() {
        repository = new UserRepository();
    }

    // T001
    @Test
    @DisplayName("validación de existencia de usuario a seguir")
    void VerifyUserExistence() {

        //arrange
        User expectedSeller = new User(20, "Juan", true);
        User expectedFollower = new User(30, "Miguel", false);

        //act
        repository.follow(expectedFollower, expectedSeller);

        //assert
        Assertions.assertTrue(expectedSeller.getSeguidores().contains(expectedFollower));
    }

    // T002
    @Test
    @DisplayName("validación de existencia de usuario a dejar de seguir")
    void VerifyUserToUnFollowExistence() {

        //arrange
        User expectedSeller = new User(20, "Juan", true);
        User expectedFollower = new User(30, "Miguel", false);

        //act
        repository.unFollow(expectedFollower, expectedSeller);

        //assert
        Assertions.assertFalse(expectedSeller.getSeguidores().contains(expectedFollower));
    }

}
