package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.*;
import sprint1.socialmeli.exceptions.UserNotFound;
import sprint1.socialmeli.model.Post;

import java.util.List;

public interface IProductService {
    /**
     * Recibe un PostRequestDTO e intenta convertirlo a Post. Si esta conversion falla,
     * lanza una excepcion del tipo InvalidPostException. Si logra convertir el Post, llama al metodo save de un
     * IPostRepository.
     * @param post PostRequestDTO que se quiere guardar.
     * @return PostId el id del post que se creó.
     */
    Integer save(PostRequestDTO post);

    /**
     * Retorna la lista de posteos de todos los seguidos por un usuario, que se hayan publicado al menos en 2 semanas
     * Este método recibe el índice de un usuario #userFollowerID que sigue determinado grupo de vendedores (otros usuarios)
     * que postean. Al invocar este método se obtendrá la lista de posteos de aquellos usuarios que se hayan hecho en un
     * lapso no mayor a dos semanas. Ademas recibe un parámetro de ordenamiento #order. El cual permitirá ordenar dicha
     * lista de posteos según sea el caso.
     * @param userFollowerID indice del usuario seguidor
     * @param order orden para expresar
     * @return ResponsePostListDTO
     * @throws UserNotFound si alguno de los usuarios no fue encontrado
     */
    ResponsePostListDTO get2WeeksProductsOfFollowed(int userFollowerID, String order);

    /**
     * Recibe un DiscountPostRequestDTO e intenta convertirlo a Post. Si esta conversion falla, lanza una excepcion
     * del tipo InvalidPostException. Si logra convertir el Post, llama al metodo save de un IPostRepository.
     * @param post DiscountPostRequestDTO que se quiere guardar
     * @return PostId el id del post que se creo
     */
    Integer saveWithDiscount(PromoPostRequestDTO post);

    /**
     * Recibe el ID de un usuario y cuenta la cantidad de Posts con descuento que tiene publicados
     * @param userId Integer
     * @return Integer count
     */
    PromoPostCountDTO getPromoPostCount(Integer userId);

    /**
     * Recibe el ID de un usuario y devuelve el listado de Posts con descuento
     * @param userId Integer
     * @return PromoPostListDTO listado de posts
     */
    PromoPostListDTO getPromoPosts(Integer userId);

    /**
     * Devuelve todos los posts de todos los usuarios de la plataforma, ordenados primero por descuento y luego por fecha
     * @return List<Post> Listado de posts ordenados por descuento y fecha
     */
    List<Post> getAll();

}
