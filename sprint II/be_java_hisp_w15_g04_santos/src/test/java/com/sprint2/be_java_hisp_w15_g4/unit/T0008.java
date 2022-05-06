package com.sprint2.be_java_hisp_w15_g4.unit;

import com.sprint2.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint2.be_java_hisp_w15_g4.model.Post;
import com.sprint2.be_java_hisp_w15_g4.model.User;
import com.sprint2.be_java_hisp_w15_g4.repository.IUserRepository;
import com.sprint2.be_java_hisp_w15_g4.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class T0008 {
    @Mock
    private IUserRepository repo;

    @InjectMocks
    private ProductService service;

    @Test
    @DisplayName("Obtiene unicamente las publicaciones de las ultimas 2 semanas")
    void ultimas2SemanasOK() {
        // Arrange
        User user = new User(1, "nombre1");
        User user2 = new User(2, "nombre2");
        User user3 = new User(3, "nombre3");

        user.addFollowing(user2); //el user sigue al user2
        user2.addFollower(user);

        user.addFollowing(user3); //el user sigue al user3
        user3.addFollower(user);

        user2.addPost(newPost(LocalDate.now().minusDays(3))); //deberia aparecer
        user2.addPost(newPost(LocalDate.now().minusDays(14))); //deberia aparecer

        user3.addPost(newPost(LocalDate.now().minusDays(3))); //deberia aparecer
        user3.addPost(newPost(LocalDate.now().minusDays(2).minusYears(2)));
        user3.addPost(newPost(LocalDate.now().minusDays(3).minusMonths(4)));

        // Mock
        Mockito.when(repo.findUser(user.getUser_id())).thenReturn(user);

        // Act
        List<LocalDate> fechas = service
                                    .lastTwoWeeksPosts(user.getUser_id(), null)
                                    .getPosts()
                                    .stream().map(PostDTO::getDate)
                                    .collect(Collectors.toList());
        // Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(fechas.stream().allMatch(p -> p.isAfter(LocalDate.now().minusDays(15)))),
                () -> Assertions.assertEquals(3, fechas.size())
        );
                //se le restan 15 dias para que considere el caso limite, sino habria que hacer un equals ademas
    }

    private Post newPost(LocalDate fecha) {
        Post post = new Post();
        post.setDate(fecha);
        return post;
    }
}
