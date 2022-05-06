package sprint2.socialmeli.unit.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import sprint2.socialmeli.dto.user.ResponseFollowersCountDTO;
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
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class SocialMeliServiceTest{

    @Mock
    ISocialMeliRepository mockSocialMeliRepository;

    @InjectMocks
    SocialMeliService socialMeliService;

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

    // T-0007
    @Test
    @DisplayName(" Verifica que la cantidad de seguidores de un usuario sea correcto")
    public void test07verifyFollowersByUserDos () {
        // arrange
        mockTwoUsers(1,2);
        mockTwoUsers(3,4);

        socialMeliService.follow(1, 2);
        socialMeliService.follow(3, 2);
        socialMeliService.follow(4, 2);
        // act
        ResponseFollowersCountDTO user = socialMeliService.countFollowers(2);
        // assert
        Assertions.assertEquals(3, user.getFollowersCount());
    }
    // ---------------------- Private ---------------------------------

    private void mockTwoUsersAndOneAsFollower(Integer followerId, Integer followedId) {
        User followerUser = UserFactory.createAnUserWithId(followerId);
        User followedUser = UserFactory.createAnUserWithId(followedId);
        followerUser.follow(followedUser);
        Mockito.when(mockSocialMeliRepository.existUser(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockSocialMeliRepository.findUserById(followerId)).thenReturn(followerUser);
        Mockito.when(mockSocialMeliRepository.findUserById(followedId)).thenReturn(followedUser);
    }

    private void mockAFollowerUserWhenFollowedDoesNotExist(Integer followerId, Integer followedId) {
        mockAnUser(followerId);
        Mockito.when(mockSocialMeliRepository.existUser(followedId)).thenReturn(false);
    }

    private int mockAnUser(User aMockUser) {
        int testId = 1;
        Mockito.when(this.mockSocialMeliRepository.findUserById(testId)).thenReturn(aMockUser);
        Mockito.when(this.mockSocialMeliRepository.existUser(testId)).thenReturn(true);
        return testId;
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

    //-- FOLLOWER

    private void assertThatIfAParamInGivenThrowExceptionInFollower(String invalidParam) {
        //Arrange
        int testId = mockAnUser(UserFactory.createAnUser());
        String errorMessage = "Los parámetros ingresados son incorrectos. Este endpoint admite solo:\\n\" +\n" + "\"order=name_asc\\n\" +\n" + " \"order=name_desc\"";
        //Act + Assert
        Assertions.assertThrows(InvalidParamsException.class,()->socialMeliService.listFollowers(testId, invalidParam),errorMessage);
    }

    private void assertThatIfAParamInGivenNotThrowExceptionInFollower(String validOrder) {
        //Arrange
        int testId = mockAnUser(UserFactory.createAnUser());
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

        int testId = mockAnUser(anInfluencer);

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
        int testId = mockAnUser(UserFactory.createAnUser());
        String errorMessage = "Los parámetros ingresados son incorrectos. Este endpoint admite solo:\\n\" +\n" + "\"order=date_asc\\n\" +\n" + " \"order=date_desc\"";

        //Act + Assert
        Assertions.assertThrows(InvalidParamsException.class,()->socialMeliService.listFollowed(testId, invalidParam),errorMessage);
    }

    private void assertThatIfAParamInGivenNotThrowExceptionInFollowed(String validOrder) {
        //Arrange
        int testId = mockAnUser(UserFactory.createAnUser());
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

        int testId = mockAnUser(aFollowerUser);

        ResponseFollowedListDTO aDtoWithTheList = socialMeliService.listFollowed(testId, validOrder);
        List<UserDTO> aSortedList = aDtoWithTheList.getFollowed();

        Assertions.assertAll(
                () -> Assertions.assertEquals(aSortedList.get(i).getUserName(), AInfluencer.getName()),
                () -> Assertions.assertEquals(aSortedList.get(i1).getUserName(), BInfluencer.getName()),
                () -> Assertions.assertEquals(aSortedList.get(i2).getUserName(), CInfluencer.getName())
        );
    }



}
