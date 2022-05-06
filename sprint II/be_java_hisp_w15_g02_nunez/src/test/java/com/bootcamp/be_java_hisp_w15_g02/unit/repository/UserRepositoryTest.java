package com.bootcamp.be_java_hisp_w15_g02.unit.repository;

import com.bootcamp.be_java_hisp_w15_g02.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.UserRepository;
import com.bootcamp.be_java_hisp_w15_g02.unit.utils.Global;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    private IUserRepository userRepository;

    @BeforeEach
    void setup() {
        Global.getListOfUsers();
        userRepository = new UserRepository();
    }

    @Test
    @DisplayName("Verify if the user to follow exist")
    public void verifyUserToFollowExist(){
        //act and assert
        Assertions.assertTrue(userRepository.follow(4, 5));
    }

    @Test
    @DisplayName("Verify if the user to follow exist error ")
    public void verifyUserToFollowExistError(){
        //act and assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userRepository.follow(1, 10));
    }

    @Test
    @DisplayName("Verify if the user to follower")
    public void verifyUserToFollower(){
        //act and assert
        userRepository.follow(4, 5);

        boolean followExist = userRepository.getUserById(1).getFollowList().stream().filter(item -> item.getUserToFollow() == 4).count()>0?true:false;
        Assertions.assertTrue(followExist);
    }

    @Test
    @DisplayName("Verify if the user to follow exist error ")
    public void verifyUserToUnfollowExist(){
        //act and assert
        Assertions.assertTrue(userRepository.unFollow(1, 4));
    }

    @Test
    @DisplayName("Verify if the user to follow exist error ")
    public void verifyUserToUnfollowExistError(){
        //act and assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userRepository.unFollow(1, 10));
    }
}
