package com.example.be_java_hisp_w15_g07.utils;

import com.example.be_java_hisp_w15_g07.dto.request.ProductDTO;
import com.example.be_java_hisp_w15_g07.dto.response.PostDTO;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PostFactory {

    private static LocalDate now = LocalDate.now();

    public static List<Post> getThreePostsOneOutdated(){

        Product product1 = new Product(1, "Computadora", "Electrodomesticos", "Samsung", "Negro", "");
        Post post1 = new Post(now.minusDays(1), product1, 2, 100000d);

        Product product2 = new Product(2, "Aire Acondicionado", "Electrodomesticos", "LG", "Blanco", "");
        Post post2 = new Post(now.minusDays(20), product2, 3, 87000d);


        Product product3 = new Product(3, "Pava eléctrica", "Electrodomesticos", "Philip", "Negro", "");
        Post post3 = new Post(now.minusDays(13), product3, 4, 4000d);

        return List.of(post1, post2, post3);
    }

    public static List<Post> getTwoPostsOneOutdated(){

        Product product1 = new Product(1, "Computadora", "Electrodomesticos", "Samsung", "Negro", "");
        Post post3 = new Post(now.minusDays(1), product1, 2, 100000d);

        Product product2 = new Product(2, "Aire Acondicionado", "Electrodomesticos", "LG", "Blanco", "");
        Post post4 = new Post(now.minusDays(20), product2, 3, 87000d);

        return List.of(post3, post4);
    }

    public static List<PostDTO> getPostsDTO(){
        Product product1 = new Product(1, "Computadora", "Electrodomesticos", "Samsung", "Negro", "");
        Post post1 = new Post(now.minusDays(1), product1, 2, 100000d);
        Product product3 = new Product(3, "Pava eléctrica", "Electrodomesticos", "Philip", "Negro", "");
        Post post2 = new Post(now.minusDays(13), product3, 4, 4000d);
        Post post3 = new Post(now.minusDays(1), product1, 2, 100000d);
        List<Post> posts = List.of(post1, post2, post3);
        return posts
                .stream()
                .map(p ->
                        new PostDTO(null, p.getDate(),
                                    new ProductDTO(p.getDetail().getProductId(),
                                            p.getDetail().getProductName(),
                                            p.getDetail().getType(),
                                            p.getDetail().getBrand(),
                                            p.getDetail().getColor(),
                                            p.getDetail().getNotes()),
                                    p.getCategory(),
                                    p.getPrice()))
                .collect(Collectors.toList());
    }
}
