package sprint1.socialmeli.service;

import sprint1.socialmeli.dto.ResponseFollowedListDTO;
import sprint1.socialmeli.dto.ResponseFollowersCountDTO;
import sprint1.socialmeli.dto.ResponseFollowersListDTO;
import sprint1.socialmeli.exceptions.InvalidFollower;
import sprint1.socialmeli.exceptions.InvalidParamsException;
import sprint1.socialmeli.exceptions.InvalidUserNameException;
import sprint1.socialmeli.exceptions.UserNotFound;

public interface ISocialMeliService {

    /**
     * Usuario en primer id, sigue al usuario del segundo id.
     * Este método recibe dos argumentos(int) : “userID” y “userIdToFollow”. Ambos argumentos indican el número asociado a dicho un usuario. Al ejecutarse, el usuario con ID “userID” dejara de seguir al usuario con ID “userIdToFollow”, ambos IDs pasados por parámetros..
     * @param userID indice del usuario seguidor
     * @param userIdToFollow índice del usuario a seguir
     * @throws UserNotFound en caso de no existir un usuario con dicho ID.
     * @throws InvalidFollower en caso de que el usuario seguidor ya siga al usuario seguido.
     */
    void follow(Integer userID, Integer userIdToFollow);

    /**
     * Hace que un usuario deje de seguir a otro
     * Este metodo recibe dos indices #userID y #userIdToUnfollow.Ambos indices referencian a sus respectivos usuarios. Al ejecutar esta funcion el usuario con ID #userID dejara de seguir al usuario con ID #userIdToUnfollow
     * @param userID indice del usuario seguidor
     * @param userIdToUnfollow indice del usuario seguido, el cual se dejara de seguir.
     * @throws UserNotFound si alguno de los usuarios no fue encontrado
     * @throws InvalidFollower si el usuario quiere dejar de seguirse a si mismo o trata de dejar de seguir a alguien que no sigue
     */
    void unfollow(int userID, int userIdToUnfollow);

    /**
     * Cuenta la cantidad de seguidores de un usuario.
     * Recibe un id de usuario por parámetro, valida a través del mismo que haya un usuario con ese ID, lo recupera, lo mapea a un DTO que se encarga de obtener el conteo de los seguidores a través de un .size() a la lista de Followers.
     * @param userID índice del usuario a consultar.
     * @return ResponseFollowersCountDTO
     * @throws UserNotFound en caso de no existir un usuario con dicho ID.
     */
    public ResponseFollowersCountDTO countFollowers(Integer userID);

    /**
     * Ver la lista de seguidores de un determinado usuario.
     * Recibe un id de usuario y un string opcional indicando un orden por parámetro, valida a través del id recibido que haya un usuario con ese ID, lo recupera. En caso de que haya algún valor en el string order, ordena la lista de Followers según el criterio del parámetro, y en caso de que el valor sea nulo, no ordena la misma. Luego se mapea al DTO y lo devuelve.
     * @param userId índice del usuario a consultar.
     * @param order tipo de orden a realizar (es nullable)
     * @return ResponseFollowersListDTO
     * @throws UserNotFound en caso de no existir un usuario con dicho ID.
     * @throws InvalidParamsException en caso de que el tipo de orden ingresado sea incorrecto.
     */
    public ResponseFollowersListDTO listFollowers(Integer userId, String order);

    /**
     * Ver la lista de seguidos de un determinado usuario.
     * Recibe un id de usuario y un string opcional indicando un orden por parámetro, valida a través del id recibido que haya un usuario con ese ID, lo recupera. En caso de que haya algún valor en el string order, ordena la lista de Followed según el criterio del parámetro, y en caso de que el valor sea nulo, no ordena la misma. Luego se mapea al DTO y lo devuelve.
     * @param userId índice del usuario a consultar.
     * @param order tipo de orden a realizar (es nullable).
     * @return ResponseFollowedListDTO
     * @throws UserNotFound en caso de no existir un usuario con dicho ID.
     * @throws InvalidParamsException en caso de que el tipo de orden ingresado sea incorrecto.
     */
    public ResponseFollowedListDTO listFollowed(Integer userId, String order);

    /**
     * Permite guardar un nuevo usuario en la base de datos. Lanza una excepcion si se intenta registrar con un nombre
     * de usuario ya existente.
     * @param name String
     * @return Integer userId
     * @throws InvalidUserNameException en caso de que ya haya un usuario registrado con ese nombre
     */
    Integer save(String name);
}
