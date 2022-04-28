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

    ResponsePromoPostCountDTO countPromoPostOfUser(int userId);

    ResponsePostListOfUser listPostsOfUser(int userId);

}
