package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.unit.service;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostServiceImpl;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.PostFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.PostListDTOFactory;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;
    @Mock
    private UserService userService;
    @Mock
    FollowRepository followRepository;
    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("Parametro de ordenamiento por fecha existente y permitir ejecucion")
    public void test_005(){
        //arrange
        Long idUser= 1L;
        String order = "date_asc";
        int days = 14;
        User user = UserFactory.createLuky();

        PostListDTO expected = PostListDTOFactory.createSimpleList();
        Mockito.when(followRepository.findFollowedByUserId(idUser)).thenReturn(Arrays.asList(user));
        Mockito.when(postRepository.getAllPostsByUserWithinTimespan(user,days)).thenReturn(PostFactory.createList(user));

        //act
        PostListDTO result = postService.getPostsByFollowedUsers(idUser, order);

        //assert
        Assertions.assertEquals(expected.getUserId(), result.getUserId());
    }


    @Test
    @DisplayName("Parametro de ordenamiento por fecha inexistente, corta ejecucion")
    public void test_005_NotValidParameter(){
        //arrange
        Long idUser= 1L;
        String order = "date_ascs";

        //act
        //assert
        Assertions.assertThrows(InvalidArgumentException.class, () -> postService.getPostsByFollowedUsers(idUser, order));
    }



    private void test_06_SortedPostList(String order) {
        // Arrange
        Long id = 1L;
        User u2 = UserFactory.createJesu();
        User u3 = UserFactory.createGonza();

        List<User> followingList = List.of(u2, u3);

        Mockito.when(followRepository.findFollowedByUserId(id)).thenReturn(followingList);

        Post post1 = PostFactory.create(u2, LocalDate.now().minusDays(5)  , 1 , 1000F);
        Post post2 = PostFactory.create(u3, LocalDate.now().minusDays(10)  , 1 , 1000F);


        Mockito.when(postRepository.getAllPostsByUserWithinTimespan(u2, 14)).thenReturn(List.of(post1));
        Mockito.when(postRepository.getAllPostsByUserWithinTimespan(u3, 14)).thenReturn(List.of(post2));

        Comparator<LocalDate> comp;

        if(order.equals("date_desc"))
            comp = Comparator.reverseOrder();
        else
            comp = Comparator.naturalOrder();

        List<LocalDate> postsAll = Stream.of(post1.getDate(), post2.getDate())
                                   .sorted(comp)
                                   .collect(Collectors.toList());


        // Act
        List<LocalDate> resultPosts = postService.getPostsByFollowedUsers(id, order)
                                              .getPosts().stream()
                                              .map(x-> LocalDate.parse(x.getDate()))
                                              .collect(Collectors.toList());

        // Assert
        Assertions.assertEquals(postsAll, resultPosts);
    }

    @Test
    @DisplayName("Test 06 - SortedPostList - date_asc")
    public void test_06_SortedPostList_date_asc() {
        test_06_SortedPostList("date_asc");
    }

    @Test
    @DisplayName("Test 06 - SortedPostList - date_desc")
    public void test_06_SortedPostList_date_desc() {
        test_06_SortedPostList("date_desc");
    }
}
