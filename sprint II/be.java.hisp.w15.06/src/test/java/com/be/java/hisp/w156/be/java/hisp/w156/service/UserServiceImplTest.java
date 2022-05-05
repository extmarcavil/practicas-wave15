package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.InvalidOrderException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.UserFactory.*;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.UserFactory.anUser;
import static com.be.java.hisp.w156.be.java.hisp.w156.utils.UserFactory.otherUser;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    @DisplayName("Verificar la acción de “Follow” (seguir) a un determinado vendedor. Se añade a la lista.")
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
    @DisplayName("Verificar la acción de “Follow” (seguir) a un determinado vendedor. Se cumple con status ok.")
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
    @DisplayName("Verificar que el usuario a dejar de seguir exista. Se elimina de la lista.")
    void whenTheUserToUnFollowExists_isRemoveFromList() {
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
    @DisplayName("Verificar que el usuario a dejar de seguir exista. Se cumple con status ok.")
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
    @DisplayName("Verificar que la cantidad de seguidores de un determinado usuario sea correcta.")
    void whenTheUserHasFollowersThenNumbersFollowersIsCorrect(){
        user.setFollowers(List.of(otherUser(),anUserUnFollower()));
        when(repository.getUser(user.getId())).thenReturn(user);

        ResponseEntity<UserCountFollowersDTO> response = userService.getCountFollowers(user.getId());

        assertThat(response.getBody().getFollowers_count()).isEqualTo(2);
    }

    @Test
    @DisplayName("Verificar que la cantidad de seguidores de un determinado usuario sea correcta con el nombre.")
    void whenTheUserHasFollowersThenCheckNameIsTheSame(){
        user.setFollowers(List.of(otherUser(),anUserUnFollower()));
        when(repository.getUser(user.getId())).thenReturn(user);

        String response = userService.getCountFollowers(user.getId()).getBody().getUser_name();

        assertThat(response).isEqualTo(user.getName());
    }

    @Test
    @DisplayName("Obtener excepción al verificar que el tipo de ordenamiento alfabético no es valido al ordenar lista de seguidores.")
    void whenFollowersAlphabeticalOrderingIsNotValidThenReturnsException(){
        String order = "order";

        assertThatThrownBy(() -> userService.getFollowers(user.getId(), order))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("El tipo de ordenamiento no es valido.");
    }

    @Test
    @DisplayName("Obtener excepción al verificar que el tipo de ordenamiento alfabético no es valido al ordenar lista de seguidos.")
    void whenFollowedAlphabeticalOrderingIsNotValidThenReturnsException(){
        String order = "order";

        assertThatThrownBy(() -> userService.getFollowed(user.getId(), order))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("El tipo de ordenamiento no es valido.");
    }

    @DisplayName("Verificar el correcto ordenamiento ascendente y descendente por nombre para seguidores.")
    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc", ""})
    void whenFollowersAlphabeticalOrderingIsValidThenReturnsStatusOk(String order){
        when(repository.getUser(user.getId())).thenReturn(user);

        assertThat(userService.getFollowers(user.getId(), order).getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @DisplayName("Verificar el correcto ordenamiento ascendente y descendente por nombre para seguidos.")
    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc", ""})
    void whenFollowedAlphabeticalOrderingIsValidThenReturnsStatusOk(String order){
        when(repository.getUser(user.getId())).thenReturn(user);

        assertThat(userService.getFollowed(user.getId(), order).getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}