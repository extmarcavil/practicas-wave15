package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.unit.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.UserDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.FollowRequestDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.UserIdDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.WhoAndHowManyFollowsMeRequestDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.OwnFollowingException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.UserNotFoundException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserServiceImpl;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.FollowFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.FollowersListFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.ResponseDTOFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PostRepository postRepository;
    @Mock
    private FollowRepository followRepository;
    @InjectMocks
    private UserServiceImpl userService;


    @Test
    @DisplayName("Un usuario puede seguir a otro service")
    public void test_01_followService() {
        // Arrange
        Long id1 = 1L;
        Long id2 = 2L;
        User u1 = UserFactory.createLuky();
        User u2 = UserFactory.createJesu();
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(u1));
        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(u2));
        Mockito.when(postRepository.isseller(ArgumentMatchers.any(User.class))).thenReturn(true);
        Mockito.when(followRepository.save(u1, u2)).thenReturn(FollowFactory.create(u1, u2));
        ResponseDTO expected = ResponseDTOFactory.create("Followed!");

        FollowRequestDTO dto = new FollowRequestDTO();
        dto.setUserId(id1);
        dto.setUserIdToFollow(id2);
        // Act
        ResponseDTO result = userService.follow(dto);

        // Assert
        Mockito.verify(followRepository).save(u1, u2);
        Assertions.assertEquals(expected.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Un usuario no puede seguir a otro que no exista")
    public void test_01_followUnexistentUser() {
        // Arrange
        Long id1 = 1L;
        Long id2 = 36721L;
        User u1 = UserFactory.createLuky();
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(u1));
        Mockito.when(userRepository.findById(36721L)).thenThrow(UserNotFoundException.class);

        FollowRequestDTO dto = new FollowRequestDTO();
        dto.setUserId(id1);
        dto.setUserIdToFollow(id2);
        // Act
        // Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.follow(dto));
    }

    @Test
    @DisplayName("Un usuario debe dejar de seguir a otro que exista")
    public void test_02_unfollowAnExistentUser() {
        // Arrange
        Long id1 = 1L;
        Long id2 = 2L;
        User u1 = UserFactory.createLuky();
        User u2 = UserFactory.createJesu();
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(u1));
        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(u2));
        Mockito.doNothing().when(followRepository).unFollow(u1, u2);
        ResponseDTO expected = ResponseDTOFactory.create("Unfollowed");

        FollowRequestDTO dto = new FollowRequestDTO();
        dto.setUserId(id1);
        dto.setUserIdToFollow(id2);
        // Act
        ResponseDTO result = userService.unFollow(dto);

        // Assert
        Mockito.verify(followRepository).unFollow(u1, u2);
        Assertions.assertEquals(expected.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Un usuario no puede dejar de seguir a otro que no exista")
    public void test_02_unfollowAnUnexistentUser() {
        // Arrange
        Long id1 = 1L;
        Long id2 = 123L;
        User u1 = UserFactory.createLuky();
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(u1));
        Mockito.when(userRepository.findById(123L)).thenThrow(UserNotFoundException.class);

        FollowRequestDTO dto = new FollowRequestDTO();
        dto.setUserId(id1);
        dto.setUserIdToFollow(id2);
        // Act

        // Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.unFollow(dto));
    }



    @Test
    @DisplayName("Un usuario no puede dejar de seguirse a si mismo")
    public void testExceptionOwnFollowedExcepcion() {
        // Arrange
        Long id1 = 1L;

        FollowRequestDTO dto = new FollowRequestDTO();
        dto.setUserId(id1);
        dto.setUserIdToFollow(id1);
        // Act
        // Assert
        Assertions.assertThrows(OwnFollowingException.class, () -> userService.unFollow(dto));
    }


    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    @DisplayName("Verificar ordenamiento alfabético descendente de seguidores")
    public void test_04_sortedFollowerList(String order) {
        // Arrange
        Long id = 1L;
        User u1 = UserFactory.createLuky();
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(u1));

        List<Follow> follows = new ArrayList<>();

        User u2 = UserFactory.createJesu();
        User u3 = UserFactory.createGonza();

        follows.add(FollowFactory.create(u2, u1));
        follows.add(FollowFactory.create(u3, u1));

        List<String> expectedFollowerNames;

        Comparator<String> comp;

        if(order.equals("name_desc"))
            comp = Comparator.reverseOrder();
        else
            comp = Comparator.naturalOrder();

        expectedFollowerNames = follows.stream().map(x -> x.getFollower().getUserName()).sorted(comp).collect(Collectors.toList());

        Mockito.when(followRepository.whoFollows(id)).thenReturn(follows);

        WhoAndHowManyFollowsMeRequestDTO dto = new WhoAndHowManyFollowsMeRequestDTO();
        dto.setUserId(id);
        dto.setOrder(order);

        // Act
        List<UserDTO> resultList = userService.whoFollowsMe(dto).getFollowers();
        List<String> resultFollowerNames = resultList.stream().map(UserDTO::getUserName).collect(Collectors.toList());

        // Assert
        Assertions.assertEquals(expectedFollowerNames, resultFollowerNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    public void test_04_sortedFollowingList(String order) {
        // Arrange
        Long id = 1L;
        User u1 = UserFactory.createLuky();
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(u1));

        User u2 = UserFactory.createJesu();
        User u3 = UserFactory.createGonza();

        List<User> followingList = List.of(u2, u3);

        List<String> expectedFollowingNames;

        Comparator<String> comp;

        if(order.equals("name_desc"))
            comp = Comparator.reverseOrder();
        else
            comp = Comparator.naturalOrder();

        expectedFollowingNames = followingList.stream().map(User::getUserName).sorted(comp).collect(Collectors.toList());

        Mockito.when(followRepository.findFollowedByUserId(id)).thenReturn(followingList);

        WhoAndHowManyFollowsMeRequestDTO dto = new WhoAndHowManyFollowsMeRequestDTO();
        dto.setUserId(id);
        dto.setOrder(order);

        // Act
        List<UserDTO> resultList = userService.findAllFollowedByUserId(dto).getFollowed();

        List<String> resultFollowerNames = resultList.stream().map(UserDTO::getUserName).collect(Collectors.toList());

        // Assert
        Assertions.assertEquals(expectedFollowingNames, resultFollowerNames);
    }

    @Test
    @DisplayName("Parametro de ordenamiento alfabetico existente, sigue ejecucion")
    public void test_003(){
        //arrange
        Long id = 1L;
        String order = "name_asc";
        User u1 = UserFactory.createLuky();
        Mockito.when(followRepository.whoFollows(id)).thenReturn(FollowersListFactory.createLista());
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(u1));

        WhoAndHowManyFollowsMeRequestDTO dto = new WhoAndHowManyFollowsMeRequestDTO();
        dto.setUserId(id);
        dto.setOrder(order);

        //act
        FollowersListDTO lista = userService.whoFollowsMe(dto);

        //assert
        Assertions.assertEquals(2L,lista.getFollowers().get(0).getUserId());
    }


    @Test
    @DisplayName("Parametro de ordenamiento no existente, arroja excepcion InvalidArgumentException")
    public void test_003NotValidParameter(){
        //arrange
        Long id= 1L;
        String order = "name_ascs";

        WhoAndHowManyFollowsMeRequestDTO dto = new WhoAndHowManyFollowsMeRequestDTO();
        dto.setUserId(id);
        dto.setOrder(order);

        //act
        //assert
        Assertions.assertThrows(InvalidArgumentException.class, () -> userService.whoFollowsMe(dto));
    }


    @Test
    @DisplayName("Cantidad de followers correcta")
    public void test_007CorrectCountFollowers(){
        //arrange
        Long userId = 1L;
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(UserFactory.createLuky()));
        Mockito.when(followRepository.whoFollows(userId)).thenReturn(FollowersListFactory.createLista());

        UserIdDTO dto = new UserIdDTO();
        dto.setUserId(userId);

        //act
        FollowersCountDTO result = userService.wowManyFollowsMe(dto);

        //assert
        Assertions.assertEquals(1,result.getFollowersCount());
    }

}
