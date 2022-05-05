package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.UserFactory.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    private IUserRepository repository;

    @InjectMocks
    private UserServiceImpl userService;
    
    private User user;

    @BeforeEach
    void setUp() {
        user = anUser();
        repository.save(user);
    }

    @Test
    void whenTheUserToFollowDoestNotExist_thenAnExceptionIsThrown() {
        Integer idToFollowNonexistent = 4;
        when(repository.getUser(any())).thenThrow(new UserNotFoundException(idToFollowNonexistent));

        assertThatThrownBy(() -> userService.follow(user.getId(), idToFollowNonexistent))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("El usuario con ID: " + idToFollowNonexistent + " no fue encontrado");
    }

    @Test
    void whenTheUserToFollowExists_isAddedToList() {
        User otherUser = otherUser();
        when(repository.getUser(user.getId())).thenReturn(user);
        when(repository.getUser(otherUser.getId())).thenReturn(otherUser);

        userService.follow(user.getId(), otherUser.getId());

        List<User> followed = user.getFollowed();
        List<User> followers = otherUser.getFollowers();

        assertThat(followed.size()).isEqualTo(1);
        assertThat(followers.size()).isEqualTo(1);
    }

    @Test
    void whenTheUserToFollowExists_theResponseEntityIsReturnedWithStatus200() {
        User otherUser = otherUser();
        when(repository.getUser(user.getId())).thenReturn(user);
        when(repository.getUser(otherUser.getId())).thenReturn(otherUser);

        ResponseEntity<SuccessDTO> response = userService.follow(user.getId(), otherUser.getId());

        String expectedMessage = String.format("The id user: %s had follow user %s", user.getId(), otherUser.getId());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void whenTheUserToUnFollowExists_isAddedToList() {
        User otherUser = otherUser();
        when(repository.getUser(user.getId())).thenReturn(user);
        when(repository.getUser(otherUser.getId())).thenReturn(otherUser);

        userService.follow(user.getId(), otherUser.getId());

        List<User> followed = user.getFollowed();
        List<User> followers = otherUser.getFollowers();

        userService.unfollow(user.getId(), otherUser.getId());

        assertThat(followed.isEmpty()).isTrue();
        assertThat(followers.isEmpty()).isTrue();
    }

    @Test
    void whenTheUserToUnFollowExists_theResponseEntityIsReturnedWithStatus200(){
        User userWithAFollower = anUserUnFollower();
        ArrayList<User> listUsers = new ArrayList<>();
        listUsers.add(userWithAFollower);
        user.setFollowed(listUsers);
        when(repository.getUser(user.getId())).thenReturn(user);
        when(repository.getUser(userWithAFollower.getId())).thenReturn(userWithAFollower);

        ResponseEntity<SuccessDTO> response = userService.unfollow(user.getId(),userWithAFollower.getId());
        String expectedMessage = String.format("The id user: %s had unfollow user %s", user.getId(),userWithAFollower.getId());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void whenTheUserHasFollowersThenNumbersFollowersIsCorrect(){
        user.setFollowers(List.of(otherUser(),anUserUnFollower()));
        when(repository.getUser(user.getId())).thenReturn(user);

        ResponseEntity<UserCountFollowersDTO> response = userService.getCountFollowers(user.getId());

        assertThat(response.getBody().getFollowers_count()).isEqualTo(2);
    }

    @Test
    void whenTheUserHasFollowersThenCheckNameIsTheSame(){
        user.setFollowers(List.of(otherUser(),anUserUnFollower()));
        when(repository.getUser(user.getId())).thenReturn(user);

        String response = userService.getCountFollowers(user.getId()).getBody().getUser_name();

        assertThat(response).isEqualTo(user.getName());
    }
}