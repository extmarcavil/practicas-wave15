package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository {

    Post createPost(User user, LocalDate date, Product detail, Integer category, Float price, Boolean promo, Float discount);

    Integer howManyPromoPostById(Long id);

    boolean isSeller(User user);

    List<Post> getAllPostsByUserWithinTimeStamp(User user, int daysBack);

    Post updatePost(Long postId, User user, LocalDate date, Product detail, Integer category, Float price, Boolean promo, Float discount);

    List <Post> getAllPostsByUserId(Long userId);
}
