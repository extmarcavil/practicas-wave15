package sprint1.socialmeli.service;

import org.springframework.stereotype.Service;
import sprint1.socialmeli.dto.user.ResponseFollowedListDTO;
import sprint1.socialmeli.dto.user.ResponseFollowersCountDTO;
import sprint1.socialmeli.dto.user.ResponseFollowersListDTO;
import sprint1.socialmeli.exceptions.InvalidParamsException;
import sprint1.socialmeli.exceptions.UserNotFound;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.ISocialMeliRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class SocialMeliService implements ISocialMeliService {

    ISocialMeliRepository repository;
    public SocialMeliService(ISocialMeliRepository repository) {
        this.repository = repository;
    }

    @Override
    public void follow(Integer userID, Integer userIdToFollow) {
        User followerUser = getUserFromRepositoryById(userID);
        User followedUser = getUserFromRepositoryById(userIdToFollow);
        followerUser.follow(followedUser);
    }

    @Override
    public void unfollow(int userID, int userIdToUnfollow) {
        User followerUser = getUserFromRepositoryById(userID);
        User followedUser = getUserFromRepositoryById(userIdToUnfollow);
        followerUser.unfollow(followedUser);
    }

    @Override
    public ResponseFollowersCountDTO countFollowers(Integer userID) {
        User anUserToCountTheirFollowers = getUserFromRepositoryById(userID);
        return new ResponseFollowersCountDTO(anUserToCountTheirFollowers);
    }

    @Override
    public ResponseFollowersListDTO listFollowers(Integer userId, String order) {
        User anUserToGetTheirListOfFollowers = getUserFromRepositoryById(userId);
        List<User> orderListOfFollowers = sortListOfUsers(
                anUserToGetTheirListOfFollowers.getListOfFollowers(),
                order);
        return new ResponseFollowersListDTO(anUserToGetTheirListOfFollowers,orderListOfFollowers);
    }

    @Override
    public ResponseFollowedListDTO listFollowed(Integer userId, String order) {
        User anUserToGetTheirListOfFollowed = getUserFromRepositoryById(userId);
        List<User> orderListOfFollowed = sortListOfUsers(
                anUserToGetTheirListOfFollowed.getListOfFollowed(),
                order);
        return new ResponseFollowedListDTO( anUserToGetTheirListOfFollowed, orderListOfFollowed );  }

    //----------Private----------//

    /**
     * Retorna el usuario buscado a través de un parámetro de ID recibido.
     * @param userID identificador del usuario a buscar.
     * @return user retorna el usuario en caso de que lo encuentre.
     */
    private User getUserFromRepositoryById(Integer userID) {
        existUser(userID, "Usuario con id:");
        return this.repository.findUserById(userID);
    }

    /**
     * Comprueba que el parámetro order sea correcto. Si el parametro es nulo lo define
     * como name_asc por defecto
     * @param order orden a aplicar. Los parámetros admitidos son name_asc y name_desc.
     * @throws InvalidParamsException en caso de que el tipo de orden ingresado sea incorrecto.
     * @return orden chequeado
     */
    private static String checkOrderParam(String order) {
        if (order == null)
            return "name_asc";
        if (!(order.equalsIgnoreCase("name_asc") || order.equalsIgnoreCase("name_desc"))) {
            throw new InvalidParamsException("Los parámetros ingresados son incorrectos. Este endpoint admite solo:\n" +
                    "order=name_asc\n" +
                    "order=name_desc");
        }
        return order;
    }

    /**
     * Recibe una lista de User y una String de ordenamiento y ordena la lista acorde al orden.
     * @param users Lista de usuarios a ordenar.
     * @param order orden a aplicar. Los parámetros admitidos son name_asc y name_desc.
     * retorna List<User> la lista ordenada
     */
    private List<User> sortListOfUsers(List<User> users, String order) {
        order = checkOrderParam(order);
        switch(order){
            case "name_desc":
                users.sort(Comparator.comparing(User::getName).reversed());
                break;
            case "name_asc":
                users.sort(Comparator.comparing(User::getName));
                break;
        }
        return users;
    }

    /**
     * Verifica si el usuario existe en el repositorio.
     * Busca un usuario a través de un ID recibido por parámetro, y en caso de no existir lanza la excepción UserNotFound con un mensaje recibido por parámetro.
     * @param userId ídentificador del usuario a buscar.
     * @param msg mensaje al lanzar la excepción.
     * @throws UserNotFound en caso de no existir un usuario con dicho ID.
     */
    private void existUser(Integer userId, String msg) {
        if( !this.repository.existUser(userId)){
            throw new UserNotFound(msg + " "+ userId + " no fue encontrado");
        }
    }
}
