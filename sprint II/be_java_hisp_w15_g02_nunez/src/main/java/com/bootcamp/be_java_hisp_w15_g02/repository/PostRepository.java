package com.bootcamp.be_java_hisp_w15_g02.repository;

import com.bootcamp.be_java_hisp_w15_g02.exception.PostNotFoundException;
import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements  IPostRepository {
    private List<Post> listPost;

    public PostRepository() {
        listPost = new ArrayList<>();
        init();
    }

    @Override
    public void createPost(Post newPost) {
        listPost.add(newPost);
    }

    @Override
    public Post findPostById(int postId) {
        return listPost.stream().filter(f ->
            f.getPostId() == postId
        ).findFirst().orElse(null);
    }

    @Override
    public List<Post> postsByUser(int userId) {
        var filter = listPost.stream().filter(f -> f.getUserId() == userId).collect(Collectors.toList());
        if(filter.size() > 0)
            return filter;
        else
            throw  new PostNotFoundException();
    }

    @Override
    public List<Post> all() {
        return listPost;
    }

    private void init(){
        listPost.add(
                new Post(1,4, LocalDate.parse("2022-03-20"),1,
                        new Product(1,"iphone 13","electronic","apple","black",
                                    "iphone 128 GB"),13000));
        listPost.add(
                new Post(2,4, LocalDate.parse("2022-04-25"),2,
                        new Product(2,"iphone 12","electronic","apple","rose gold",
                                "iphone 64 GB"),10000));
        listPost.add(
                new Post(3,4, LocalDate.parse("2022-04-21"),3,
                        new Product(3,"iphone 11","electronic","apple","blue",
                                "iphone 256 GB"),9000));
        listPost.add(
                new Post(4,5, LocalDate.parse("2022-04-10"),4,
                        new Product(4,"iphone se","electronic","apple","red",
                                "iphone 64 GB"),7000));
        listPost.add(
                new Post(5,5, LocalDate.now(),5,
                        new Product(5,"iphone XR","electronic","apple","white",
                                "iphone 128 GB"),5000));
        listPost.add(
                new Post(6,5, LocalDate.parse("2022-05-03"),5,
                        new Product(6,"cama","electronic","apple","white",
                                "cama grande"),6000));

    }
}
