package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.*;
import sprint1.socialmeli.exceptions.UserNotFound;

public interface IProductService {
    /**
     * Recibe un RequestPostDTO e intenta convertirlo a Post. Si esta conversion falla,
     * lanza una excepcion del tipo InvalidPostException. Si logra convertir el Post, llama al metodo save de un
     * IPostRepository.
     * @param post RequestPostDTO que se quiere guardar.
     * @return PostId el id del post que se creó.
     */
    Integer save(RequestPostDTO post);

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
     * Recibe un RequestPromoPostDTO e intenta convertirlo a Post. Si esta conversion falla,
     * lanza una excepcion del tipo InvalidPostException. Si logra convertir el Post, llama al metodo save de un
     * IPostRepository.
     * @param promoPost RequestPromoPostDTO que se quiere guardar.
     * @return PostId el id del promo post que se creó.
     */
    Integer savePromoPost(RequestPromoPostDTO promoPost);



    /**
     * Cuenta la cantidad de productos en promoción de un usuario.
     * Recibe un id de usuario por parámetro, valida a través del mismo que haya un usuario con ese ID y lo recupera,
     * luego cuenta la cantidad de productos en promoción que tiene ese usuario en la lista postList del repositorio PostRepository
     * @param userId índice del usuario a consultar.
     * @throws UserNotFound en caso de no existir un usuario con dicho ID.
     * @return ResponseFollowersCountDTO
     */
    ResponseCountPromoPostDTO countPromoPost(int userId);



    /**
     * Retorna la lista de posteos de productos en promoción de todos los seguidos por un usuario, que se encuentren dentro del rango de precio requerido
     * ordenados por precio.
     * Este método recibe el índice de un usuario #userId que sigue determinado grupo de vendedores (otros usuarios)
     * que postean. Al invocar este método se obtendrá la lista de posteos de productos en promoción de aquellos usuarios que estan
     * dentro del rango de precio entre #minPrice y #maxPrice ordenada por precio de menor a mayor.
     * @param userId indice del usuario seguidor
     * @param minPrice precio minimo
     * @param maxPrice precio máximo
     * @return ResponsePromoPostListDTO
     * @throws UserNotFound si el usuario no fue encontrado
     */
    ResponsePromoPostListDTO getAllPromoProductByPriceRangeOfFollowed(int userId, double minPrice, double maxPrice);
}
