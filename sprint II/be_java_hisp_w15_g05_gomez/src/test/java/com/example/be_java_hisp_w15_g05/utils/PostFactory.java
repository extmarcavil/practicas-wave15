package com.example.be_java_hisp_w15_g05.utils;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.PostIdDTO;
import com.example.be_java_hisp_w15_g05.dto.ProductDTO;
import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.Product;

import java.time.LocalDate;
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

    public static PostDTO galperinNewPostDTO(){
        return new PostDTO(1,LocalDate.of(2022,5,6),pDTO1,100,202.0);
    }

    public static PostDTO errorDatePostDTO(){
        return new PostDTO(
                1,
                LocalDate.of(2022,4,6),
                pDTO1,
                100,
                202.0);
    }

    public static PostDTO errorPostDTO(){
        return new PostDTO(
                1,
                LocalDate.of(2022,5,6),
                new ProductDTO(0,null,null,"asd$",null,"a"),
                100,
                202.0);
    }
}
