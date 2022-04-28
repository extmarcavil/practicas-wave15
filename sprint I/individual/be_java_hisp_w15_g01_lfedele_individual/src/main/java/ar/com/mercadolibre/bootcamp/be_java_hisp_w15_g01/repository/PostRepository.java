package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository {

    Post create(User user, LocalDate date, Product detail, Integer category, Float price);

	boolean isseller(User user);

    List<Post> getAllPostsByUserWithinTimespan(User user, int daysBack);

    List<Post> getUserPromoPosts(Long id);

    Integer getUserPromoPostsCount(Long id);

    Post createPostPromo(Post post);
}
