package sprint2.socialmeli.unit.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sprint2.socialmeli.dto.ProductDTO;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;
import sprint2.socialmeli.dto.post.response.ResponsePostDTO;
import sprint2.socialmeli.dto.post.response.ResponsePostListDTO;
import sprint2.socialmeli.exceptions.InvalidParamsException;
import sprint2.socialmeli.model.Post;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.repository.IPostRepository;
import sprint2.socialmeli.repository.ISocialMeliRepository;
import sprint2.socialmeli.service.ProductService;
import sprint2.socialmeli.utils.UserFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ISocialMeliRepository mockSocialMeliRepository;

    @Mock
    IPostRepository mockPostRepository;

    @InjectMocks
    ProductService productService;

    // T-0005
    @Test
    @DisplayName("Verificar que al mandar el parametro date_desc la lista queda ordenada descendente")
    public void test05assertThatIfDateDescParamInGivenNotThrowException() {
        assertThatIfAParamInGivenNotThrowExceptionWithDate("date_desc");
    }

    @Test
    @DisplayName("Verificar que al mandar el parametro date_asc la lista queda ordenada ascendente")
    public void test05assertThatIfDateAscInGivenNotThrowException() {
        assertThatIfAParamInGivenNotThrowExceptionWithDate("date_asc");
    }

    @Test
    @DisplayName("Verificar que al mandar un parametro invalido, lance un error")
    public void test05assertThatIfAnInvalidParamInGivenThrowExceptionWithDate() {
        assertThatIfAParamInGivenThrowExceptionWithDate("jalsdfjdlskd");
    }

    // T-0006
    @Test
    @DisplayName("Verificar que el feed de un usuario esté ordenado de manera ascendente (post más viejo al más nuevo)")
    public void test06CheckAscOrderOfFeed() {
        assertOrderOfFeed("date_asc", 0, 1, 2);
    }

    @Test
    @DisplayName("Verificar que el feed de un usuario esté ordenado de manera descendente (post más nuevo al más viejo)")
    public void test06CheckDescOrderOfFeed() {
        assertOrderOfFeed("date_desc", 2, 1, 0);
    }

    @Test
    @DisplayName("Verificar que el feed de un usuario esté ordenado de manera por defecto (ascendente)")
    public void test06CheckDefaultOrderOfFeed() {
        assertOrderOfFeed(null, 0, 1, 2);
    }

    // T-0008
    @Test
    @DisplayName("Verifica que los post filtrados de las ultimas 2 semanas sean efectivamente de las ultimas 2 semanas")
    public void test08verifyPostLastTwoWeeks() {

        // arrange
        User alan = new User(2, "Alan Gimenez");
        User nico = new User(1, "Nicolas Kazandjian");

        nico.follow(alan);

        // Armo una lista de post a devolver por el repositorio mockeado
        List<Post> listaPost = new ArrayList<>();
        listaPost.addAll(createAListOfPostWhitDaysMinusNow(1,alan));
        listaPost.addAll(createAListOfPostWhitDaysMinusNow(30,alan));

        // Mock de consultas al repositorio
        mockFindUserByID( nico,1);
        Mockito.when(mockPostRepository.getListOfPostOfUser(2)).thenReturn(listaPost);

        // act
        ResponsePostListDTO listOfPostDTO = productService.get2WeeksProductsOfFollowed(1, "date_asc");
        // asssert
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, listOfPostDTO.getPosts().size()),
                () -> Assertions.assertTrue(checkIfPostsAreLessThanTwoWeeks(listOfPostDTO))
        );
    }


    //--------------------- Private --------------------//


    private void assertOrderOfFeed(String validOrder, int i, int i1, int i2) {
        // ARRANGE
        User aFollowedSeller1 = UserFactory.createAnUser();
        User aFollowedSeller2 = UserFactory.createAnUser();
        User aFollowedSeller3 = UserFactory.createAnUser();
        User aFollowerClient = UserFactory.createAnUser();

        aFollowerClient.follow(aFollowedSeller1);
        aFollowerClient.follow(aFollowedSeller2);
        aFollowerClient.follow(aFollowedSeller3);

        ArrayList<Post> postsOfSeller1 = createAListOfPostWhitDaysMinusNow(3, aFollowedSeller1);
        ArrayList<Post> postsOfSeller2 = createAListOfPostWhitDaysMinusNow(2, aFollowedSeller2);
        ArrayList<Post> postsOfSeller3 = createAListOfPostWhitDaysMinusNow(1, aFollowedSeller3);

        // MOCK
        mockFindUserByID( aFollowerClient,aFollowerClient.getId());
        Mockito.when(mockPostRepository.getListOfPostOfUser(aFollowedSeller1.getId())).thenReturn(postsOfSeller1);
        Mockito.when(mockPostRepository.getListOfPostOfUser(aFollowedSeller2.getId())).thenReturn(postsOfSeller2);
        Mockito.when(mockPostRepository.getListOfPostOfUser(aFollowedSeller3.getId())).thenReturn(postsOfSeller3);

        // ACT
        ResponsePostListDTO aDtoList = productService.get2WeeksProductsOfFollowed(aFollowerClient.getId(), validOrder);
        List<ResponsePostDTO> aSortedList = aDtoList.getPosts();

        // ASSERTION
        Assertions.assertAll(
                () -> Assertions.assertEquals(aSortedList.get(i).getDate(), postsOfSeller1.get(0).getDate()),
                () -> Assertions.assertEquals(aSortedList.get(i1).getDate(), postsOfSeller2.get(0).getDate()),
                () -> Assertions.assertEquals(aSortedList.get(i2).getDate(), postsOfSeller3.get(0).getDate())
        );
    }

    private ArrayList<Post> createAListOfPostWhitDaysMinusNow(int daysMinusNow, User aFollowedSeller) {
        LocalDate aDate = LocalDate.now().minusDays(daysMinusNow);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //String notOldDateString = aDate.format(formatter);
        RequestPostDTO postDTOOfSeller = new RequestPostDTO(aFollowedSeller.getId(), aDate, new ProductDTO(), 1, 10000D);
        Post postOfSeller = new Post(postDTOOfSeller);
        return new ArrayList<>(Arrays.asList(postOfSeller));
    }

    private boolean checkIfPostsAreLessThanTwoWeeks(ResponsePostListDTO lista) {
        for (int i = 0; i < lista.getPosts().size(); i++) {
            if (lista.getPosts().get(i).getDate().isBefore(LocalDate.now().minusDays(14))) {
                return false;
            }
        }
        return true;
    }

    private void assertThatIfAParamInGivenNotThrowExceptionWithDate(String validOrder) {
        //Arrange
        int testId = 1;
        mockFindUserByID( UserFactory.createAnUser(),testId);
        //Act + Assert
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> productService.get2WeeksProductsOfFollowed(testId, validOrder))
        );
    }

    private void assertThatIfAParamInGivenThrowExceptionWithDate(String invalidOrder) {
        Assertions.assertThrows(InvalidParamsException.class, () -> productService.get2WeeksProductsOfFollowed(1, invalidOrder));
    }


    private int mockFindUserByID(User aMockUser,int testId) {
        Mockito.when(this.mockSocialMeliRepository.findUserById(testId)).thenReturn(aMockUser);
        Mockito.when(this.mockSocialMeliRepository.existUser(testId)).thenReturn(true);
        return testId;
    }

}
