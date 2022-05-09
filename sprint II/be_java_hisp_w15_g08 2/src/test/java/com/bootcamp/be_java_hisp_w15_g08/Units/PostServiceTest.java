package com.bootcamp.be_java_hisp_w15_g08.Units;

import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g08.service.ProductService;
import com.bootcamp.be_java_hisp_w15_g08.service.UserService;
import com.bootcamp.be_java_hisp_w15_g08.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;


@ExtendWith(MockitoExtension.class)
public class PostServiceTest {


    @Mock
    IUserRepository repository;

    @InjectMocks
    ProductService service;

    @Test
    @DisplayName("Comprobar si existe el date_asc")
    public void date_asc() {
        //arrange
        String order = "date_asc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        PostListDTO result = service.getSellersLastsPosts(user1.getUserID(), order);

        //asert
        Assert.isInstanceOf(PostListDTO.class, result);
    }

    @Test
    @DisplayName("Comprobar si existe el date_asc")
    public void date_desc() {
        //arrange
        String order = "date_asc";
        User user1 = Util.user1();

        //Mock
        Mockito.when(repository.findUser(user1.getUserID())).thenReturn(user1);

        //act
        PostListDTO result = service.getSellersLastsPosts(user1.getUserID(), order);


        //asert

        Assert.isInstanceOf(PostListDTO.class, result);
    }

}

