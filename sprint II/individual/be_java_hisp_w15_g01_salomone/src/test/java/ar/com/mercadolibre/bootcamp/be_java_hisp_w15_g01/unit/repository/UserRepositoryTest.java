package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.unit.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;


public class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    public void initialize(){
        this.userRepository = new UserRepositoryImpl();
    }


    @Test
    @DisplayName("Verifico FindByID existente")
    public void test(){
        //arrange
        Long idUser = 1L;
        Long expected = 1L;

        //act
        Optional<User> result = userRepository.findById(idUser);

        //assert
        Assertions.assertEquals(expected, result.get().getUserId());
    }


    @Test
    @DisplayName("Verifico FindByID no existente")
    public void testError(){
        //arrange
        Long idUser = 7L;
        Optional<User> expected = Optional.empty();

        //act
        Optional<User> result = userRepository.findById(idUser);

        //assert
        Assertions.assertEquals(expected, result);
    }

}
