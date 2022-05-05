package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.InvalidOrderException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import com.be.java.hisp.w156.be.java.hisp.w156.utils.PostFactory;
import com.be.java.hisp.w156.be.java.hisp.w156.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.be.java.hisp.w156.be.java.hisp.w156.utils.PostFactory.getListPostLast2Weeks;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private IUserRepository repository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void whenPostDateOrderingIsNotValidThenReturnsException(){
        String order = "order";

        when(repository.getUser(any())).thenThrow(new InvalidOrderException());

        assertThatThrownBy(() -> productService.getPostsLastTwoWeekById(1, order))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("El tipo de ordenamiento no es valido.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc", ""})
    void whenPostDateOrderingIsValidThenReturnsStatusOk(String order){
        User user = UserFactory.anUser();

        when(repository.getUser(any())).thenReturn(user);

        assertThat(productService.getPostsLastTwoWeekById(user.getId(), order).getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    @DisplayName("Verificar  la consulta de publicaciones realizadas sean de las ultimas 2 semanas ")
    public void whenGetPostsLastTwoWeekById(){
        //arrange
        int userId = 1;
        String order = "date_asc";

        Mockito.when(repository.getUser(userId)).thenReturn(getListPostLast2Weeks());

        List<ResponsePostDTO> expected = PostFactory.getPosts();

        //act
        ResponseEntity<RecentlyPostDTO> result = productService.getPostsLastTwoWeekById(userId, order);

        //asset
        Assertions.assertArrayEquals(expected.toArray(), result.getBody().getPosts().toArray());
    }
}