package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.exception.InvalidOrderException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import com.be.java.hisp.w156.be.java.hisp.w156.utils.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

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

}