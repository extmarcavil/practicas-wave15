package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Post create(User user, LocalDate date, Product detail, Integer category, Float price,Boolean hasPromo, Double discount);

	boolean isseller(User user);

    List<Post> getAllPostsByUserWithinTimespan(User user, int daysBack);

    List<Post> getListOfPromoPosts(Long id);

    Optional<Product> findProductById(Long id);

    Cart addProductToPurchase(User user, Product product);

    List<Product> getListOfProducts(Long id);

    Boolean existByUserAndProduct(Product product, User user);
}
