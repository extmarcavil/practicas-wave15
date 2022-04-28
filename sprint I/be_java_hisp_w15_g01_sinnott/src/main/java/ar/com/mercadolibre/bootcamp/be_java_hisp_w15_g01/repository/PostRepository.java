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
     * @return El post creado
     */
    Post createPost(User user, LocalDate date, Product detail, Integer category, Float price, Boolean promo, Float discount);

    /**
     * PostRepository
     * Obtiene la cantidad de posts en promocion de un usuario
     *
     * @param id El id del usuario
     * @return La cantidad de posts en promocion
     */
    Integer howManyPromoPostById(Long id);

    /**
     * PostRepository
     * Dice si user es vendedor
     *
     * @param user El owner del post
     * @return True si es vendedor
     */
    boolean isSeller(User user);

    /**
     * PostRepository
     * Obtiene una lista de todos los posts que realizo user en los pasados daysBack dias
     *
     * @param user El owner de los posts
     * @param daysBack La cantidad de dias atras a buscar
     * @return La lista de posts
     */
    List<Post> getAllPostsByUserWithinTimeStamp(User user, int daysBack);

    /**
     * PostRepository
     * Crea un post
     *
     * @param user El owner del post
     * @param date La fecha de creacion
     * @param detail El detalle del post
     * @param category La categoria del post
     * @param price El precio del post
     * @param promo Si es promocion
     + @param discount El descuento
     * @return El post creado
     */
    Post updatePost(Long postId, User user, LocalDate date, Product detail, Integer category, Float price, Boolean promo, Float discount);

    /**
     * PostRepository
     * Obtiene una lista de todos los posts de un usuario
     *
     * @param userId El owner de los posts
     * @return La lista de posts
     */
    List <Post> getAllPostsByUserId(Long userId);
}
