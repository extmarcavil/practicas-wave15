package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ProductDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PostFactory {

    public static List<Post> createList(User user){
        Product detail = new Product(1L, "asd", "type", "brand", "black", "");
        Post p1 = new Post();
        p1.setPostId(1L);
        p1.setCategory(2);
        p1.setDetail(detail);
        p1.setPrice(1F);
        p1.setDate(LocalDate.now());
        p1.setUser(user);


        return Arrays.asList(p1);
    }

}
