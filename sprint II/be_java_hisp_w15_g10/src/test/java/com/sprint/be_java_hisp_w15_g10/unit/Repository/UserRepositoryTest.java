package com.sprint.be_java_hisp_w15_g10.unit.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class UserRepositoryTest {

    UserRepository userRepository;

    @BeforeEach
    void setUp(){
        userRepository = new UserRepository();
    }

    @Test
    void getValidUserById() {
        // arrange
        User user_followed = TestUtils.createFollowedUser(userRepository);

        //act
        Optional<User> user = userRepository.getById(4);

        // assert
        Assertions.assertEquals(user.get(), user_followed);
    }

    @Test
    void getInvalidUserById() {
        // arrange
        TestUtils.createFollowedUser(userRepository);

        //act
        Optional<User> user = userRepository.getById(10);

        // assert
        Assertions.assertTrue(user.isEmpty());
    }

    @Test
    void getAll() {
        // arrange
        TestUtils.createFollowedUser(userRepository);

        //act
        List<User> users = userRepository.getAll();

        // assert
        Assertions.assertAll(
                ()->{Assertions.assertFalse(users.isEmpty());},
                ()->{Assertions.assertEquals(users.size(),7);}
        );
    }


    @Test
    void add() {
        // arrange
        User user = new User(4, "José");
        int initial_size = userRepository.getAll().size();
        // act
        userRepository.add(user);
        int final_size = userRepository.getAll().size();
        // assert
        Assertions.assertAll(
                ()->{Assertions.assertEquals(initial_size + 1, final_size);},
                ()->{Assertions.assertEquals(user, userRepository.getById(4).get());}
        );
    }
}