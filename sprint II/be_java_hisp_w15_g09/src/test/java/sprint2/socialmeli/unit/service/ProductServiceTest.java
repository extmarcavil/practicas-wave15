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
import sprint2.socialmeli.model.Post;
import sprint2.socialmeli.model.User;
import sprint2.socialmeli.repository.IPostRepository;
import sprint2.socialmeli.repository.ISocialMeliRepository;
import sprint2.socialmeli.service.ProductService;
import sprint2.socialmeli.utils.UserFactory;

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


    // T-0006

    @Test
    @DisplayName("Verificar que el feed de un usuario esté ordenado de manera ascendente (post más nuevo al más viejo)")
    public void test06xxx (){
        //ARRANGE
        User a = UserFactory.createAnUser();
        User b = UserFactory.createAnUser();
        User c = UserFactory.createAnUser();
        User user = UserFactory.createAnUser();

        user.follow(a);
        user.follow(b);
        user.follow(c);

        RequestPostDTO postA = new RequestPostDTO(a.getId(), "01-05-2022", new ProductDTO(), 1, 10000D);
        RequestPostDTO postB = new RequestPostDTO(b.getId(), "02-05-2022", new ProductDTO(), 1, 10000D);
        RequestPostDTO postC = new RequestPostDTO(c.getId(), "03-05-2022", new ProductDTO(), 1, 10000D);

        Post postAA = new Post(postA);
        Post postBB = new Post(postB);
        Post postCC = new Post(postC);

        ArrayList<Post> aSortedPostOfA = new ArrayList<>(Arrays.asList(postAA)) ;
        ArrayList<Post> aSortedPostOfB = new ArrayList<>(Arrays.asList(postBB)) ;
        ArrayList<Post> aSortedPostOfC = new ArrayList<>(Arrays.asList(postCC)) ;

        // Mock
        int testId = mockFindUserByID(user, user.getId());
        Mockito.when(mockPostRepository.getListOfPostOfUser(a.getId())).thenReturn(aSortedPostOfA);
        Mockito.when(mockPostRepository.getListOfPostOfUser(b.getId())).thenReturn(aSortedPostOfB);
        Mockito.when(mockPostRepository.getListOfPostOfUser(c.getId())).thenReturn(aSortedPostOfC);

        //ACT
        ResponsePostListDTO aDtoList = productService.get2WeeksProductsOfFollowed(testId, "date_asc");
        List<ResponsePostDTO> aSortedList = aDtoList.getPosts();

        //ASSERTION
        Assertions.assertAll(
                () -> Assertions.assertEquals(aSortedList.get(0).getDate(), postAA.getDate()),
                () -> Assertions.assertEquals(aSortedList.get(1).getDate(), postBB.getDate()),
                () -> Assertions.assertEquals(aSortedList.get(2).getDate(), postCC.getDate())
        );
    }


    private int mockFindUserByID(User aMockUser, int testId) {
        Mockito
                .when(
                        this.mockSocialMeliRepository.findUserById(testId))
                .thenReturn(
                        aMockUser
                );
        return testId;
    }

}

