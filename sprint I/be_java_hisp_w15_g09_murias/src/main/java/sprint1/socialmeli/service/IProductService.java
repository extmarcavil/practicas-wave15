package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.*;
import sprint1.socialmeli.exceptions.UserNotFound;

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
     * Recibe un PromoPostRequestDTO e intenta convertirlo a Post. Si esta conversion falla,
     * lanza una excepcion del tipo InvalidPostException. Si logra convertir el Post, llama al metodo save de un
     * IPostRepository.
     * @param post PromoPostRequestDTO que se quiere guardar.
     * @return PostId el id del post que se creó.
     */
    Integer save(PromoPostRequestDTO post);

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
     * Retorna la cantidad de posteos realiazdos por un usuario.
     * @param userId indice del usuario
     * @return ResponsePromoPostCountDTO
     * @throws UserNotFound si el usuario no es encontradoo
     */
    ResponsePromoPostCountDTO countPromoPostOfUser(int userId);


    /**
     * Retorna la lista de posteos realizados por un usuario
     * Este método recibe el identificador de un usuario userId. Al invocar este método se obtendrá la lista de posteos realizados por el mismo (ya sean de productos promo o no).
     * @param userId indice del usuario seguidor
     * @return ResponsePostListOfUser
     * @throws UserNotFound si alguno de los usuarios no fue encontrado
     */
    ResponsePostListOfUser listPostsOfUser(int userId);

}
