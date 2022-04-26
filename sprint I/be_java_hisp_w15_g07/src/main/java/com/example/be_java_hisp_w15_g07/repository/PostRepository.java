package com.example.be_java_hisp_w15_g07.repository;

import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.Product;
import com.example.be_java_hisp_w15_g07.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {
    private Map<Integer, Post> database;

    public PostRepository() {
        this.database = new HashMap<>();
        initDatabase();
    }

    private void initDatabase(){
        Product product = new Product(1, "Televisor 43", "Electrodomesticos", "Samsung", "Negro", "");
        Post post = new Post(1, 1, LocalDate.of(2020, Month.APRIL, 10), product, 1, 60000d);
        database.put(post.getPostId(), post);

        product = new Product(2, "Computadora", "Electrodomesticos", "Samsung", "Negro", "");
        post = new Post(2, 1, LocalDate.of(2022, Month.APRIL, 10), product, 2, 100000d);
        database.put(post.getPostId(), post);

        product = new Product(3, "Aire Acondicionado", "Electrodomesticos", "LG", "Blanco", "");
        post = new Post(3, 3, LocalDate.of(2022, Month.MARCH, 17), product, 3, 87000d);
        database.put(post.getPostId(), post);

        product = new Product(4, "Pava eléctrica", "Electrodomesticos", "Philip", "Negro", "");
        post = new Post(4, 2, LocalDate.of(2020, Month.JUNE, 12), product, 4, 4000d);
        database.put(post.getPostId(), post);

        product = new Product(5, "Heladera", "Electrodomesticos", "Samsung", "Blanca", "");
        post = new Post(5, 1, LocalDate.of(2020, Month.JULY, 22), product, 5, 180000d);
        database.put(post.getPostId(), post);

        product = new Product(6, "Celular", "Electronica", "Motorola", "Blanco", "");
        post = new Post(6, 1, LocalDate.of(2021, Month.DECEMBER, 2), product, 6, 87000d);
        database.put(post.getPostId(), post);

        product = new Product(7, "Tostadora", "Electrodomesticos", "Volkswagen", "Blanco", "4 modos");
        post = new Post(7, 3, LocalDate.of(2022, Month.APRIL, 3), product, 7, 20000d);
        database.put(post.getPostId(), post);

        product = new Product(8, "Pantalla 50", "Electrodomesticos", "TopHouse", "Plateado", "");
        post = new Post(8, 2, LocalDate.of(2020, Month.APRIL, 10), product, 8, 68000d);
        database.put(post.getPostId(), post);
    }
}
