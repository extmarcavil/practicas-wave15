package com.example.be_java_hisp_w15_g05.utils;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.PostIdDTO;
import com.example.be_java_hisp_w15_g05.dto.ProductDTO;
import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.Product;
import com.example.be_java_hisp_w15_g05.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostFactory {

    private static Product p1= new Product(10, "Mouse", "Tecnologia", "Raton", "Negro", "Bluetoo");
    private static Product p2 = new Product(1, "Teclado", "Tecnologia", "Teclado", "Blanco", "Bluetoo");

    private static ProductDTO pDTO1= new ProductDTO(10, "Mouse", "Tecnologia", "Raton", "Negro", "Bluetoo");
    private static ProductDTO pDTO2 = new ProductDTO(1, "Teclado", "Tecnologia", "Teclado", "Blanco", "Bluetoo");


    public static List<Post> getListPosts(){

        Post posteo = new Post(10, 20, LocalDate.of(2022, 5, 1), p1, 100, 202.00);
        Post posteo3 = new Post(10, 22, LocalDate.of(2022, 5, 2), p1, 100, 202.00);

        return (Arrays.asList(posteo, posteo3));
    }

    public static List<PostIdDTO> getListPostsDesc(){

        PostIdDTO posteo = new PostIdDTO(20, LocalDate.of(2022, 5, 1), pDTO1, 100, 202.00);
        PostIdDTO posteo2 = new PostIdDTO(22, LocalDate.of(2022, 5, 2), pDTO1, 100, 202.00);

        return (Arrays.asList(posteo, posteo2));
    }

    public static List<PostIdDTO> getListPostsAsc(){

        PostIdDTO posteo3 = new PostIdDTO(22, LocalDate.of(2022, 5, 2), pDTO1, 100, 202.00);
        PostIdDTO posteo4 = new PostIdDTO(20, LocalDate.of(2022, 5, 1), pDTO1, 100, 202.00);

        return (Arrays.asList(posteo3, posteo4));
    }

    public static List<Post> getPostsOutOfDate(){

        Post posteo = new Post(10, 20, LocalDate.of(2022, 5, 1), p1, 100, 202.00);
        Post posteo3 = new Post(10, 22, LocalDate.of(2022, 5, 2), p1, 100, 202.00);
        Post posteo4 = new Post(10, 22, LocalDate.of(2021, 4, 2), p1, 100, 202.00);

        return (Arrays.asList(posteo, posteo3,posteo4));
    }
    public static PostDTO createPost(){

        return new PostDTO(1, LocalDate.of(2022, 5, 6), pDTO2, 100, 202.00);
    }

    public static ProductDTO getpDTO2() {
        return pDTO2;
    }

    public static List<PostIdDTO> getListSellerPost() {
        ProductDTO pDTO1= new ProductDTO(10, "Mouse", "Tecnologia", "Raton", "Negro", "Bluetoo");
        ProductDTO pDTO2 = new ProductDTO(1, "Teclado", "Tecnologia", "Teclado", "Blanco", "Bluetoo");

        List<PostIdDTO> posts = new ArrayList<>();
        PostIdDTO postIdDTO1 = new PostIdDTO(21, LocalDate.of(2022, 4, 26), pDTO2, 100, 202.0);
        PostIdDTO postIdDTO2 = new PostIdDTO(23, LocalDate.of(2022, 4, 25), pDTO2, 100, 202.0);
        PostIdDTO postIdDTO3 = new PostIdDTO(22, LocalDate.of(2022, 4, 24), pDTO1, 100, 202.0);

        posts.add(postIdDTO1);
        posts.add(postIdDTO2);
        posts.add(postIdDTO3);

        return posts;
    }
}
