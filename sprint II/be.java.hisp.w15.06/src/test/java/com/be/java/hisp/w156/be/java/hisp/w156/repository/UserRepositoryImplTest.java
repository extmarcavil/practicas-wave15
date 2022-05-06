package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImpl repository;

    @Test
    void whenTheUserIdDoestNotExist_thenAnExceptionIsThrown() {
        Integer userId = 5;

        assertThatThrownBy(() -> repository.getUser(userId))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("El usuario con ID: " + userId + " no fue encontrado");
    }

    @Test
    void whenTheUserIdExist_thenReturnsTheUser() {
        Integer userId = 4;

        assertThat(repository.getUser(userId)).isNotNull();
    }

}