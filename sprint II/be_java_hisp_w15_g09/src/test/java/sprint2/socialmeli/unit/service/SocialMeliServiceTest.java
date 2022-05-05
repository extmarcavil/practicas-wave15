package sprint2.socialmeli.unit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.support.SimpleTriggerContext;
import sprint2.socialmeli.exceptions.InvalidFollower;
import sprint2.socialmeli.exceptions.UserNotFound;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.repository.ISocialMeliRepository;
import sprint2.socialmeli.repository.SocialMeliRepository;
import sprint2.socialmeli.service.ISocialMeliService;
import sprint2.socialmeli.service.SocialMeliService;

@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest{

    @Mock
    ISocialMeliRepository mockSocialMeliRepository;

    @InjectMocks
    SocialMeliService socialMeliService;

    @BeforeEach
    public void setUp(){
        //socialMeliRepository = new SocialMeliRepository();
    }

    // T-0001
    @Test
    @DisplayName("Verificar que el usuario a seguir exista")
    public void test01UserToFollowExists() {
        Integer followerId = 1;
        Integer followedId = 2;
        User followerUser = new User(followerId, "Lorena Maciel");
        User followedUser = new User(followedId, "Gonzalo Murias");

        Mockito.when(mockSocialMeliRepository.existUser(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.findUserById(followedId)).thenReturn(followedUser);

        Assertions.assertDoesNotThrow(() -> socialMeliService.follow(followerId, followedId));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).findUserById(Mockito.any(Integer.class));
    }

    @Test
    @DisplayName("Verificar que el usuario a seguir no exista")
    public void test01UserToFollowDoesNotExist() {
        Integer followerId = 1;
        Integer followedId = 200;
        String expectedMessage = "Usuario con id: " + followedId + " no fue encontrado";
        User followerUser = new User(followerId, "Lorena Maciel");

        Mockito.when(mockSocialMeliRepository.existUser(followerId)).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.existUser(followedId)).thenReturn(false);

        Assertions.assertThrows(UserNotFound.class, () -> socialMeliService.follow(followerId, followedId),expectedMessage);
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.atMostOnce()).findUserById(Mockito.any(Integer.class));
    }

    @Test
    @DisplayName("Verificar que el usuario no puede seguirse a si mismo")
    public void testUserCanNotFollowThemselves() {
        Integer userId = 1;
        String expectedMessage = "El usuario no puede seguirse a si mismo";
        User user = new User(userId, "Lorena Maciel");

        Mockito.when(mockSocialMeliRepository.existUser(userId)).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(userId)).thenReturn(user);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.follow(userId, userId),expectedMessage);
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).findUserById(Mockito.any(Integer.class));
    }

    @Test
    @DisplayName("Verificar que el usuario no puede seguir a un usuario que ya sigue")
    public void testUserCanNotFollowTheSameUserTwice() {
        Integer followerId = 1;
        Integer followedId = 2;
        String expectedMessage = "El usuario no puede seguir a alguien que ya sigue";
        User followerUser = new User(followerId, "Lorena Maciel");
        User followedUser = new User(followedId, "Gonzalo Murias");
        followerUser.getListOfFollowed().add(followedUser);

        Mockito.when(mockSocialMeliRepository.existUser(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.findUserById(followedId)).thenReturn(followedUser);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.follow(followerId, followedId),expectedMessage);
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).findUserById(Mockito.any(Integer.class));
    }

    // T-0002
    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir exista")
    public void test02UserToUnfollowExists() {
        Integer followerId = 1;
        Integer followedId = 2;
        User followerUser = new User(followerId, "Lorena Maciel");
        User followedUser = new User(followedId, "Gonzalo Murias");
        followerUser.getListOfFollowed().add(followedUser);

        Mockito.when(mockSocialMeliRepository.existUser(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.findUserById(followedId)).thenReturn(followedUser);

        Assertions.assertDoesNotThrow(() -> socialMeliService.unfollow(followerId, followedId));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).findUserById(Mockito.any(Integer.class));
    }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir no exista")
    public void test02UserToUnfollowDoesNotExist() {
        Integer followerId = 1;
        Integer followedId = 200;
        String expectedMessage = "Usuario con id: " + followedId + " no fue encontrado";
        User followerUser = new User(followerId, "Lorena Maciel");

        Mockito.when(mockSocialMeliRepository.existUser(followerId)).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.existUser(followedId)).thenReturn(false);

        Assertions.assertThrows(UserNotFound.class, () -> socialMeliService.unfollow(followerId, followedId),expectedMessage);
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.atMostOnce()).findUserById(Mockito.any(Integer.class));
    }

    @Test
    @DisplayName("Verificar que el usuario no puede dejar de seguirse a si mismo")
    public void testUserCanNotUnfollowThemselves() {
        Integer userId = 1;
        String expectedMessage = "El usuario no puede dejar de seguirse a si mismo";
        User user = new User(userId, "Lorena Maciel");

        Mockito.when(mockSocialMeliRepository.existUser(userId)).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(userId)).thenReturn(user);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.unfollow(userId, userId),expectedMessage);
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).findUserById(Mockito.any(Integer.class));
    }

    @Test
    @DisplayName("Verificar que el usuario no puede dejar de seguir a un usuario que no sigue")
    public void testUserCanNotUnfollowNotFollowedUser() {
        Integer followerId = 1;
        Integer followedId = 2;
        String expectedMessage = "El usuario no puede dejar de seguir a alguien que no sigue";
        User followerUser = new User(followerId, "Lorena Maciel");
        User followedUser = new User(followedId, "Gonzalo Murias");

        Mockito.when(mockSocialMeliRepository.existUser(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.findUserById(followedId)).thenReturn(followedUser);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.unfollow(followerId, followedId),expectedMessage);
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).findUserById(Mockito.any(Integer.class));
    }

    // T-0003
    @Test
    @DisplayName("")
    public void test03AssertThatTheOrderIsGivenIsTheCorrectOne(){

    }



}
