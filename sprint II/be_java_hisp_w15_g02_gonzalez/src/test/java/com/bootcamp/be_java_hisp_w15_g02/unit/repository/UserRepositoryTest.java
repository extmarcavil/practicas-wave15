package com.bootcamp.be_java_hisp_w15_g02.unit.repository;

import com.bootcamp.be_java_hisp_w15_g02.exception.FollowYourselfException;
import com.bootcamp.be_java_hisp_w15_g02.exception.NotSellerException;
import com.bootcamp.be_java_hisp_w15_g02.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Follow;
import com.bootcamp.be_java_hisp_w15_g02.model.User;
import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.UserRepository;
import com.bootcamp.be_java_hisp_w15_g02.service.IUserService;
import com.bootcamp.be_java_hisp_w15_g02.service.UserService;
import com.bootcamp.be_java_hisp_w15_g02.unit.utils.Global;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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
        Assertions.assertTrue(userRepository.follow(1, 5));
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
        userRepository.follow(1, 4);

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
