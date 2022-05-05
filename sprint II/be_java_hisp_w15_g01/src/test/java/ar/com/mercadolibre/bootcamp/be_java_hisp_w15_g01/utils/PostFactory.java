package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.time.LocalDate;

public class PostFactory {

    public static Post create(User user, LocalDate date, Integer category, Float price) {
        Post f = new Post();
        f.setUser(user);
        f.setDate(date);
        f.setDetail(ProductFactory.create());
        f.setCategory(category);
        f.setPrice(price);
        return f;
    }
}
