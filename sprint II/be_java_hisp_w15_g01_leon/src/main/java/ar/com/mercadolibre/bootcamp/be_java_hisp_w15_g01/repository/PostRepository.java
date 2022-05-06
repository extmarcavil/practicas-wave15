package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository {
    /**
     * PostRepository
     * Crea un post
     *
     * @param user El owner del post
     * @param date La fecha de creacion
     * @param detail El detalle del post
     * @param category La categoria del post
     * @param price El precio del post
     */
    Post create(User user, LocalDate date, Product detail, Integer category, Float price);

    /**
     * PostRepository
     * Dice si user es vendedor
     *
     * @param user El owner del post
     */
	boolean isseller(User user);

    /**
     * PostRepository
     * Obtiene una lista de todos los posts
     */
    List<Post> getPosts();

    /**
     * PostRepository
     * Obtiene una lista de todos los posts que realizo user en los pasados daysBack dias
     *
     * @param user El owner de los posts
     * @param daysBack La cantidad de dias atras a buiscar
     */
    List<Post> getAllPostsByUserWithinTimespan(User user, int daysBack);
}
