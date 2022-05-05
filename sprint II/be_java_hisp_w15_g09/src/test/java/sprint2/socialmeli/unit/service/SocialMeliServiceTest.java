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
import sprint2.socialmeli.dto.user.ResponseFollowersListDTO;
import sprint2.socialmeli.dto.user.UserDTO;
import sprint2.socialmeli.exceptions.InvalidParamsException;
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
       // socialMeliService = new SocialMeliService(mockSocialMeliRepository);
    }

    // T-0003
    @Test
    @DisplayName("Verificar que el orden name_desc existe y no lanza error ")
    public void test03AssertThatIfNameDescParameterIsGivenNotThrowException(){
        assertThatIfAParamInGivenNotThowException("name_desc");
    }

    @Test
    @DisplayName("Verificar que el orden name_asc existe y no lanza error ")
    public void test03AssertThatIfNameAscParameterIsGivenNotThrowException(){
        assertThatIfAParamInGivenNotThowException("name_asc");
    }

    @Test
    @DisplayName("Verificar que el orden null existe y no lanza error ")
    public void test03AssertThatIfNullParameterIsGivenNotThrowException(){
        assertThatIfAParamInGivenNotThowException(null);
    }

    @Test
    @DisplayName("Verificar que al pasar un orden no valido lanza un error InvalidParamsException ")
    public void test03AssertThatIfAnInvalidOrderIsGivenShouldThrowAnException(){
        assertThatIfAParamInGivenThowException("Invalid");
    }

    //T-0004
    @Test
    @DisplayName("Verificar que al mandar el parametro name_asc la lista queda ordenada ascendente")
    public void test04XX(){
        assertOrderOfFollowedUserList("name_asc", 0,1 , 2);
    }

    @Test
    @DisplayName("Verificar que al mandar el parametro name_desc la lista queda ordenada descendente")
    public void test04XXX(){
        assertOrderOfFollowedUserList("name_desc", 2, 1, 0);
    }

    //T-0004
    @Test
    @DisplayName("Verificar que al mandar null, por defecto la lista queda ordenada ascendente")
    public void test04XXXX(){
        assertOrderOfFollowedUserList(null, 0,1 , 2);
    }




    // ---------------------- Private ---------------------------------

    private void assertThatIfAParamInGivenThowException(String invalidParam) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertThrows(InvalidParamsException.class,()->socialMeliService.listFollowers(testId, invalidParam));
    }

    private void assertThatIfAParamInGivenNotThowException(String name_desc) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertDoesNotThrow(() -> socialMeliService.listFollowers(testId, name_desc));
    }

    private void assertOrderOfFollowedUserList(String name_asc, int i,int i1 ,int i2) {
        //Arrange
        User ATheFollowerUser = UserFactory.createAnUserWithName("A");
        User BTheFollowerUser = UserFactory.createAnUserWithName("B");
        User CTheFollowerUser = UserFactory.createAnUserWithName("C");

        User anInfluencer = UserFactory.createAnUser();

        BTheFollowerUser.follow(anInfluencer);
        ATheFollowerUser.follow(anInfluencer);
        CTheFollowerUser.follow(anInfluencer);

        int testId = mockFindUserByID(anInfluencer);

        ResponseFollowersListDTO aDtoWithTheList = socialMeliService.listFollowers(testId, name_asc);
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




}
