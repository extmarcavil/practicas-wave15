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
import org.mockito.verification.VerificationMode;
import sprint2.socialmeli.dto.user.ResponseFollowersCountDTO;
import sprint2.socialmeli.dto.user.ResponseFollowersListDTO;
import sprint2.socialmeli.dto.user.UserDTO;
import sprint2.socialmeli.exceptions.InvalidParamsException;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.exceptions.InvalidFollower;
import sprint2.socialmeli.exceptions.UserNotFound;
import sprint2.socialmeli.repository.ISocialMeliRepository;
import sprint2.socialmeli.service.ProductService;
import sprint2.socialmeli.service.SocialMeliService;
import sprint2.socialmeli.utils.UserFactory;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest{

    @Mock
    ISocialMeliRepository mockSocialMeliRepository;

    @Mock
    ProductService productService;

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
        mockTwoUsers(followerId, followedId);

        Assertions.assertDoesNotThrow(() -> socialMeliService.follow(followerId, followedId));
        verifyInvocationsOfExistsAndFindById(Mockito.times(2));
    }

    @Test
    @DisplayName("Verificar que el usuario a seguir no exista")
    public void test01UserToFollowDoesNotExist() {
        Integer followerId = 1;
        Integer followedId = 200;
        String expectedMessage = "Usuario con id: " + followedId + " no fue encontrado";
        mockAFollowerUserWhenFollowedDoesNotExist(followerId, followedId);

        Assertions.assertThrows(UserNotFound.class, () -> socialMeliService.follow(followerId, followedId),expectedMessage);
        verifyInvocationsOfExistsAndFindById(Mockito.atMostOnce());
    }

    @Test
    @DisplayName("Verificar que el usuario no puede seguirse a si mismo")
    public void testUserCanNotFollowThemselves() {
        Integer userId = 1;
        String expectedMessage = "El usuario no puede seguirse a si mismo";
        mockAnUser(userId);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.follow(userId, userId),expectedMessage);
        verifyInvocationsOfExistsAndFindById(Mockito.times(2));
    }

    @Test
    @DisplayName("Verificar que el usuario no puede seguir a un usuario que ya sigue")
    public void testUserCanNotFollowTheSameUserTwice() {
        Integer followerId = 1;
        Integer followedId = 2;
        String expectedMessage = "El usuario no puede seguir a alguien que ya sigue";
        mockTwoUsersAndOneAsFollower(followerId, followedId);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.follow(followerId, followedId),expectedMessage);
        verifyInvocationsOfExistsAndFindById(Mockito.times(2));
    }

    // T-0002
    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir exista")
    public void test02UserToUnfollowExists() {
        Integer followerId = 1;
        Integer followedId = 2;
        mockTwoUsersAndOneAsFollower(followerId, followedId);

        Assertions.assertDoesNotThrow(() -> socialMeliService.unfollow(followerId, followedId));
        verifyInvocationsOfExistsAndFindById(Mockito.times(2));
    }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir no exista")
    public void test02UserToUnfollowDoesNotExist() {
        Integer followerId = 1;
        Integer followedId = 200;
        String expectedMessage = "Usuario con id: " + followedId + " no fue encontrado";
        mockAFollowerUserWhenFollowedDoesNotExist(followerId, followedId);

        Assertions.assertThrows(UserNotFound.class, () -> socialMeliService.unfollow(followerId, followedId),expectedMessage);
        verifyInvocationsOfExistsAndFindById(Mockito.atMostOnce());
    }

    @Test
    @DisplayName("Verificar que el usuario no puede dejar de seguirse a si mismo")
    public void testUserCanNotUnfollowThemselves() {
        Integer userId = 1;
        String expectedMessage = "El usuario no puede dejar de seguirse a si mismo";
        mockAnUser(userId);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.unfollow(userId, userId),expectedMessage);
        verifyInvocationsOfExistsAndFindById(Mockito.times(2));
    }

    @Test
    @DisplayName("Verificar que el usuario no puede dejar de seguir a un usuario que no sigue")
    public void testUserCanNotUnfollowNotFollowedUser() {
        Integer followerId = 1;
        Integer followedId = 2;
        String expectedMessage = "El usuario no puede dejar de seguir a alguien que no sigue";
        mockTwoUsers(followerId, followedId);

        Assertions.assertThrows(InvalidFollower.class, () -> socialMeliService.unfollow(followerId, followedId),expectedMessage);
        verifyInvocationsOfExistsAndFindById(Mockito.times(2));
    }

    // T-0003
    @Test
    @DisplayName("Verificar que el orden name_desc existe y no lanza error ")
    public void test03AssertThatIfNameDescParameterIsGivenNotThrowException(){
        assertThatIfAParamInGivenNotThrowException("name_desc");
    }

    @Test
    @DisplayName("Verificar que el orden name_asc existe y no lanza error ")
    public void test03AssertThatIfNameAscParameterIsGivenNotThrowException(){
        assertThatIfAParamInGivenNotThrowException("name_asc");
    }

    @Test
    @DisplayName("Verificar que el orden null existe y no lanza error ")
    public void test03AssertThatIfNullParameterIsGivenNotThrowException(){
        assertThatIfAParamInGivenNotThrowException(null);
    }

    @Test
    @DisplayName("Verificar que al pasar un orden no valido lanza un error InvalidParamsException ")
    public void test03AssertThatIfAnInvalidOrderIsGivenShouldThrowAnException(){
        assertThatIfAParamInGivenThrowException("Invalid");
    }

    //T-0004
    @Test
    @DisplayName("Verificar que al mandar el parametro name_asc la lista queda ordenada ascendente")
    public void test04XX(){
        assertOrderOfFollowerUserList("name_asc", 0,1 , 2);
    }

    @Test
    @DisplayName("Verificar que al mandar el parametro name_desc la lista queda ordenada descendente")
    public void test04XXX(){
        assertOrderOfFollowerUserList("name_desc", 2, 1, 0);
    }

    //T-0004
    @Test
    @DisplayName("Verificar que al mandar null, por defecto la lista queda ordenada ascendente")
    public void test04XXXX(){
        assertOrderOfFollowerUserList(null, 0,1 , 2);
    }

    @Test
    @DisplayName(" verifica que la cantidad de seguidores de un usuario sea correcto")
    public void verifyFollowersByUserDos () {

        // arrange
        User alan = new User(2, "Alan Gimenez");
        User nico = new User (1, "Nicolas Kazandjian");
        User lorena = new User (3, "Lorena Bitencur");
        when(mockSocialMeliRepository.existUser(1)).thenReturn(true);
        when(mockSocialMeliRepository.existUser(2)).thenReturn(true);
        when(mockSocialMeliRepository.existUser(3)).thenReturn(true);
        when(mockSocialMeliRepository.findUserById(1)).thenReturn(nico);
        when(mockSocialMeliRepository.findUserById(2)).thenReturn(alan);
        when(mockSocialMeliRepository.findUserById(3)).thenReturn(lorena);
        /*mockFindUserByID(alan);
        mockFindUserByID(nico);
        mockFindUserByID(lorena);*/
        socialMeliService.follow(1, 2);
        socialMeliService.follow(3, 2);
        // act
        ResponseFollowersCountDTO user = socialMeliService.countFollowers(2);
        // assert
        Assertions.assertEquals(2, user.getFollowersCount());
    }

    // ---------------------- Private ---------------------------------

    private void mockTwoUsersAndOneAsFollower(Integer followerId, Integer followedId) {
        User followerUser = UserFactory.createAnUserWithId(followerId);
        User followedUser = UserFactory.createAnUserWithId(followedId);
        followerUser.getListOfFollowed().add(followedUser);

        Mockito.when(mockSocialMeliRepository.existUser(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.findUserById(followedId)).thenReturn(followedUser);
    }

    private void mockAFollowerUserWhenFollowedDoesNotExist(Integer followerId, Integer followedId) {
        mockAnUser(followerId);
        Mockito.when(mockSocialMeliRepository.existUser(followedId)).thenReturn(false);
    }

    private void mockAnUser(Integer userId) {
        User user = UserFactory.createAnUserWithId(userId);
        Mockito.when(mockSocialMeliRepository.existUser(userId)).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(userId)).thenReturn(user);
    }

    private void mockTwoUsers(Integer followerId, Integer followedId) {
        User followerUser = UserFactory.createAnUserWithId(followerId);
        User followedUser = UserFactory.createAnUserWithId(followedId);

        Mockito.when(mockSocialMeliRepository.existUser(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.findUserById(followedId)).thenReturn(followedUser);
    }

    private void verifyInvocationsOfExistsAndFindById(VerificationMode times) {
        Mockito.verify(mockSocialMeliRepository, Mockito.times(2)).existUser(Mockito.any(Integer.class));
        Mockito.verify(mockSocialMeliRepository, times).findUserById(Mockito.any(Integer.class));
    }

    private void assertThatIfAParamInGivenThrowException(String invalidParam) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertThrows(InvalidParamsException.class,()->socialMeliService.listFollowers(testId, invalidParam));
    }

    private void assertThatIfAParamInGivenNotThrowException(String validOrder) {
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



    private boolean controlParametroOrder (String validOrder) {
        if(validOrder == "date_asc" || validOrder == "date_desc") {
            return true;
        };
        return false;
    }
}
