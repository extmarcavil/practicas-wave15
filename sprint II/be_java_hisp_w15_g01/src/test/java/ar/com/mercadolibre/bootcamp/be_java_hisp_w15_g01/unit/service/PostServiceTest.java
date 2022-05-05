package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.unit.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostServiceImpl;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils.FollowersListFactory;
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

}
