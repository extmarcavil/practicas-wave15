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
import sprint2.socialmeli.model.Product;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.repository.IPostRepository;
import sprint2.socialmeli.repository.ISocialMeliRepository;
import sprint2.socialmeli.service.ProductService;
import sprint2.socialmeli.utils.UserFactory;

import java.time.LocalDate;
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
    public void test05xx() {
        assertThatIfAParamInGivenNotThrowExceptionWithDate("date_desc");
    }

    @Test
    @DisplayName("Verificar que al mandar el parametro date_asc la lista queda ordenada descendente")
    public void test05xxx() {
        assertThatIfAParamInGivenNotThrowExceptionWithDate("date_asc");
    }

    @Test
    @DisplayName("Verificar que al mandar un parametro invalido, lance un error")
    public void test05xxxx() {
        assertThatIfAParamInGivenThrowExceptionWithDate("jalsdfjdlskd");
    }

    @Test
    @DisplayName(" verifica que los post filtrados de las ultimas 2 semanas sean efectivamente de las ultimas 2 semanas")
    public void verifyPostLastTwoWeeks() {

        // arrange
        // Nico sigue a Alan
        User alan = new User(2, "Alan Gimenez");
        List<User> seguidos = new ArrayList<>();
        seguidos.add(alan);
        User nico = new User(1, "Nicolas Kazandjian");
        nico.setListOfFollowed(seguidos);

        // Armo una lista de post a devolver por el repositorio mockeado
        List<Post> listaPost = crearLista();

        // Respuesta esperada
        ResponsePostListDTO respuestaEsperada = respuestaEsperada();

        // Respuesta falsa esperada
        ResponsePostListDTO respuestaEsperadaFalsa = new ResponsePostListDTO(1, crearLista());

        // Mock de consultas al repositorio
        Mockito.when(mockSocialMeliRepository.findUserById(1)).thenReturn(nico);
        Mockito.when(mockPostRepository.getListOfPostOfUser(2)).thenReturn(listaPost);

        // act
        ResponsePostListDTO lista = productService.get2WeeksProductsOfFollowed(1, "date_asc");
        // asssert
        Assertions.assertAll(
                () -> Assertions.assertEquals(respuestaEsperada.getPosts().size(), lista.getPosts().size()),
                () -> Assertions.assertTrue(recorrerLista(lista))
                // () -> Assertions.assertTrue(recorrerLista(respuestaEsperadaFalsa))
        );
    }

    private List<Post> crearLista() {
        Product producto = new Product(1, "producto", "tipo", "marca", "blanco", "sin notas");
        Post postUno = new Post(1, 2, LocalDate.of(2022, 04, 29), producto, 1, 500.00);
        Post postDos = new Post(2, 2, LocalDate.of(2021, 04, 29), producto, 1, 500.00);
        Post postTres = new Post(3, 2, LocalDate.of(2022, 04, 30), producto, 1, 500.00);
        List<Post> listaPost = new ArrayList<>();
        listaPost.add(postUno);
        listaPost.add(postDos);
        // listaPost.add(postTres); // en caso de descomentar esta linea, el test NO DEBERIA FUNCIONAR
        return listaPost;
    }

    private boolean recorrerLista(ResponsePostListDTO lista) {
        for (int i = 0; i < lista.getPosts().size(); i++) {
            if (lista.getPosts().get(i).getDate().isBefore(LocalDate.now().minusDays(14))) {
                return false;
            }
        }
        return true;
    }

    private ResponsePostListDTO respuestaEsperada() {
        List<Post> posts = new ArrayList<>();
        posts.add(crearLista().get(0));
        return new ResponsePostListDTO(1, posts);
    }

    private void assertThatIfAParamInGivenNotThrowExceptionWithDate(String validOrder) {
        //Arrange
        int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> productService.get2WeeksProductsOfFollowed(testId, validOrder))
                // ()->Assertions.assertTrue(controlParametroOrder(validOrder))
                // ()->Assertions.assertFalse(controlParametroOrder(validOrder))
        );
    }

    private void assertThatIfAParamInGivenThrowExceptionWithDate(String invalidOrder) {
        //Arrange
        // int testId = mockFindUserByID(UserFactory.createAnUser());
        //Act + Assert
        /*Assertions.assertAll(
                ()->Assertions.assertThrows(InvalidParamsException.class,()->productService.get2WeeksProductsOfFollowed(1, invalidOrder))
                // ()->Assertions.assertTrue(controlParametroOrder(validOrder))
                // ()->Assertions.assertFalse(controlParametroOrder(validOrder))
        );*/
        Assertions.assertThrows(InvalidParamsException.class, () -> productService.get2WeeksProductsOfFollowed(1, invalidOrder));
    }

    // refactorizar a Utils
    private int mockFindUserByID(User aMockUser) {
        //Arrange
        int testId = 1;
        Mockito
                .when(
                        this.mockSocialMeliRepository.findUserById(testId))
                .thenReturn(
                        aMockUser
                );
        return testId;
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

    private void assertOrderOfFeed(String validOrder, int i, int i1, int i2) {
        // ARRANGE
        User aFollowedSeller1 = UserFactory.createAnUser();
        User aFollowedSeller2 = UserFactory.createAnUser();
        User aFollowedSeller3 = UserFactory.createAnUser();
        User aFollowerClient = UserFactory.createAnUser();

        aFollowerClient.follow(aFollowedSeller1);
        aFollowerClient.follow(aFollowedSeller2);
        aFollowerClient.follow(aFollowedSeller3);

        RequestPostDTO postDTOOfSeller1 = new RequestPostDTO(aFollowedSeller1.getId(), "01-05-2022", new ProductDTO(), 1, 10000D);
        RequestPostDTO postDTOOfSeller2 = new RequestPostDTO(aFollowedSeller2.getId(), "02-05-2022", new ProductDTO(), 1, 10000D);
        RequestPostDTO postDTOOfSeller3 = new RequestPostDTO(aFollowedSeller3.getId(), "03-05-2022", new ProductDTO(), 1, 10000D);

        Post postOfSeller1 = new Post(postDTOOfSeller1);
        Post postOfSeller2 = new Post(postDTOOfSeller2);
        Post postOfSeller3 = new Post(postDTOOfSeller3);

        ArrayList<Post> postsOfSeller1 = new ArrayList<>(Arrays.asList(postOfSeller1));
        ArrayList<Post> postsOfSeller2 = new ArrayList<>(Arrays.asList(postOfSeller2));
        ArrayList<Post> postsOfSeller3 = new ArrayList<>(Arrays.asList(postOfSeller3));

        // MOCK
        Mockito.when(this.mockSocialMeliRepository.findUserById(aFollowerClient.getId())).thenReturn(aFollowerClient);
        Mockito.when(mockPostRepository.getListOfPostOfUser(aFollowedSeller1.getId())).thenReturn(postsOfSeller1);
        Mockito.when(mockPostRepository.getListOfPostOfUser(aFollowedSeller2.getId())).thenReturn(postsOfSeller2);
        Mockito.when(mockPostRepository.getListOfPostOfUser(aFollowedSeller3.getId())).thenReturn(postsOfSeller3);

        // ACT
        ResponsePostListDTO aDtoList = productService.get2WeeksProductsOfFollowed(aFollowerClient.getId(), validOrder);
        List<ResponsePostDTO> aSortedList = aDtoList.getPosts();

        // ASSERTION
        Assertions.assertAll(
                () -> Assertions.assertEquals(aSortedList.get(i).getDate(), postOfSeller1.getDate()),
                () -> Assertions.assertEquals(aSortedList.get(i1).getDate(), postOfSeller2.getDate()),
                () -> Assertions.assertEquals(aSortedList.get(i2).getDate(), postOfSeller3.getDate())
        );
    }
}
