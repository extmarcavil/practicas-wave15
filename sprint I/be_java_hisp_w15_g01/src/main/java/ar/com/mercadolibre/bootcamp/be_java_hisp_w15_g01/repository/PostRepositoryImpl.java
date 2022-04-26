package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    List<Post> posts = new ArrayList<>();

    @Override
    public boolean create(User user, LocalDate date, Product detail, Integer category, Float price) {

        Post post = new Post();
        post.setPostId(posts.size() +1L);
        post.setUser(user);
        post.setDate(date);
        post.setDetail(detail);
        post.setCategory(category);
        post.setPrice(price);

        return posts.add(post);
    }

}
