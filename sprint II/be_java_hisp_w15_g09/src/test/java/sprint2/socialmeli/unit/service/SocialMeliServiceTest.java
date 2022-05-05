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
import sprint2.socialmeli.dto.user.ResponseFollowedListDTO;
import sprint2.socialmeli.dto.user.ResponseFollowersListDTO;
import sprint2.socialmeli.dto.user.UserDTO;
import sprint2.socialmeli.exceptions.InvalidFollower;
import sprint2.socialmeli.exceptions.InvalidParamsException;
import sprint2.socialmeli.exceptions.UserNotFound;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.repository.ISocialMeliRepository;
import sprint2.socialmeli.service.SocialMeliService;
import sprint2.socialmeli.utils.UserFactory;

import java.util.List;


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

    // T-0003 - LISTA FOLLOWERS
    @Test
    @DisplayName("Verificar que el orden name_desc existe y no lanza error en una lista de seguidores")
    public void test03AssertThatIfNameDescParameterIsGivenNotThrowExceptionOnAFollowerList(){
        assertThatIfAParamInGivenNotThrowExceptionInFollower("name_desc");
    }

    @Test
    @DisplayName("Verificar que el orden name_asc existe y no lanza error en una lista de seguidores")
    public void test03AssertThatIfNameAscParameterIsGivenNotThrowExceptionOnAFollowerList(){
        assertThatIfAParamInGivenNotThrowExceptionInFollower("name_asc");
    }

    @Test
    @DisplayName("Verificar que el orden null existe y no lanza error en una lista de seguidores")
    public void test03AssertThatIfNullParameterIsGivenNotThrowExceptionOnAFollowerList(){
        assertThatIfAParamInGivenNotThrowExceptionInFollower(null);
    }

    @Test
    @DisplayName("Verificar que al pasar un orden no valido lanza un error InvalidParamsException en una lista de seguidores")
    public void test03AssertThatIfAnInvalidOrderIsGivenShouldThrowAnExceptionOnAFollowerList(){
        assertThatIfAParamInGivenThrowExceptionInFollower("Invalid");
    }

    // T0003 - LISTA FOLLOWED

    @Test
    @DisplayName("Verificar que el orden name_desc existe y no lanza error en una lista de seguidos")
    public void test03AssertThatIfNameDescParameterIsGivenNotThrowExceptionOnAFollowedList(){
        assertThatIfAParamInGivenNotThrowExceptionInFollowed("name_desc");
    }

    @Test
    @DisplayName("Verificar que el orden name_asc existe y no lanza error en una lista de seguidos")
    public void test03AssertThatIfNameAscParameterIsGivenNotThrowExceptionOnAFollowedList(){
        assertThatIfAParamInGivenNotThrowExceptionInFollowed("name_asc");
    }

    @Test
    @DisplayName("Verificar que el orden null existe y no lanza error en una lista de seguidos")
    public void test03AssertThatIfNullParameterIsGivenNotThrowExceptionOnAFollowedList(){
        assertThatIfAParamInGivenNotThrowExceptionInFollowed(null);
    }

    @Test
    @DisplayName("Verificar que al pasar un orden no valido lanza un error InvalidParamsException en una lista de seguidos")
    public void test03AssertThatIfAnInvalidOrderIsGivenShouldThrowAnExceptionOnAFollowedList(){
        assertThatIfAParamInGivenThrowExceptionInFollowed("Invalid");
    }

    //T-0004 FOLLOWERS
    @Test
    @DisplayName("Verificar que al mandar el parametro name_asc la lista de seguidores queda ordenada ascendente")
    public void test04CheckAscOrderOnFollowerList(){
        assertOrderOfFollowerUserList("name_asc", 0,1 , 2);
    }

    @Test
    @DisplayName("Verificar que al mandar el parametro name_desc la lista de seguidores queda ordenada descendente")
    public void test04CheckDescOrderOnFollowerList(){
        assertOrderOfFollowerUserList("name_desc", 2, 1, 0);
    }

    @Test
    @DisplayName("Verificar que al mandar null, por defecto la lista de seguidores queda ordenada ascendente")
    public void test04CheckDefaultOrderOnFollowerList(){
        assertOrderOfFollowerUserList(null, 0,1 , 2);
    }


    // T-0004 FOLLOWED
    @Test
    @DisplayName("Verificar que al mandar el parametro name_asc la lista de seguidos queda ordenada ascendente")
    public void test04CheckAscOrderOnFollowedList(){
        assertOrderOfFollowedUserList("name_asc", 0,1 , 2);
    }

    @Test
    @DisplayName("Verificar que al mandar el parametro name_desc la lista de seguidos queda ordenada descendente")
    public void test04CheckDescOrderOnFollowedList(){
        assertOrderOfFollowedUserList("name_desc", 2,1 , 0);
    }

    @Test
    @DisplayName("Verificar que al mandar null, por defecto la lista de seguidos queda ordenada ascendente")
    public void test04CheckDefaultOrderOnFollowedList(){
        assertOrderOfFollowedUserList(null, 0,1 , 2);
    }

    // ---------------------- Private ---------------------------------

    //-- FOLLOWER

    private void assertThatIfAParamInGivenThrowExceptionInFollower(String invalidParam) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertThrows(InvalidParamsException.class,()->socialMeliService.listFollowers(testId, invalidParam));
    }

    private void assertThatIfAParamInGivenNotThrowExceptionInFollower(String validOrder) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertDoesNotThrow(() -> socialMeliService.listFollowers(testId, validOrder));
    }

    private void assertOrderOfFollowerUserList(String validOrder, int i, int i1 , int i2) {
        //Arrange
        User ATheFollowerUser = UserFactory.createAnUserWithName("A");
        User BTheFollowerUser = UserFactory.createAnUserWithName("B");
        User CTheFollowerUser = UserFactory.createAnUserWithName("C");

        User anInfluencer = UserFactory.createAnUser();

        BTheFollowerUser.follow(anInfluencer);
        ATheFollowerUser.follow(anInfluencer);
        CTheFollowerUser.follow(anInfluencer);

        int testId = mockFindUserByID(anInfluencer);

        ResponseFollowersListDTO aDtoWithTheList = socialMeliService.listFollowers(testId, validOrder);
        List<UserDTO> aSortedList = aDtoWithTheList.getFollowers();

        Assertions.assertAll(
                () -> Assertions.assertEquals(aSortedList.get(i).getUserName(), ATheFollowerUser.getName()),
                () -> Assertions.assertEquals(aSortedList.get(i1).getUserName(), BTheFollowerUser.getName()),
                () -> Assertions.assertEquals(aSortedList.get(i2).getUserName(), CTheFollowerUser.getName())
        );
    }

    //-- FOLLOWED
    private void assertThatIfAParamInGivenThrowExceptionInFollowed(String invalidParam) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertThrows(InvalidParamsException.class,()->socialMeliService.listFollowed(testId, invalidParam));
    }

    private void assertThatIfAParamInGivenNotThrowExceptionInFollowed(String validOrder) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertDoesNotThrow(() -> socialMeliService.listFollowed(testId, validOrder));
    }

    private void assertOrderOfFollowedUserList(String validOrder, int i, int i1 , int i2) {
        //Arrange
        User AInfluencer = UserFactory.createAnUserWithName("A");
        User BInfluencer = UserFactory.createAnUserWithName("B");
        User CInfluencer = UserFactory.createAnUserWithName("C");

        User aFollowerUser = UserFactory.createAnUser();

        aFollowerUser.follow(AInfluencer);
        aFollowerUser.follow(BInfluencer);
        aFollowerUser.follow(CInfluencer);

        int testId = mockFindUserByID(aFollowerUser);

        ResponseFollowedListDTO aDtoWithTheList = socialMeliService.listFollowed(testId, validOrder);
        List<UserDTO> aSortedList = aDtoWithTheList.getFollowed();

        Assertions.assertAll(
                () -> Assertions.assertEquals(aSortedList.get(i).getUserName(), AInfluencer.getName()),
                () -> Assertions.assertEquals(aSortedList.get(i1).getUserName(), BInfluencer.getName()),
                () -> Assertions.assertEquals(aSortedList.get(i2).getUserName(), CInfluencer.getName())
        );
    }

    private int mockFindUserByID(User aMockUser) {
        //Arrange
        int testId = 1;
        Mockito
                .when(
                        this.mockSocialMeliRepository.findUserById(testId))
                .thenReturn(
                        aMockUser
                );

        Mockito
                .when(
                        this.mockSocialMeliRepository.existUser(testId))
                .thenReturn(
                        true
                );
        return testId;
    }
}
