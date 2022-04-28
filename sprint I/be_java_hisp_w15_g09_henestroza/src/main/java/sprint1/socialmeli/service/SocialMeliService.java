package sprint1.socialmeli.service;

import org.springframework.stereotype.Service;
import sprint1.socialmeli.dto.ResponseFollowedListDTO;
import sprint1.socialmeli.dto.ResponseFollowersCountDTO;
import sprint1.socialmeli.dto.ResponseFollowersListDTO;
import sprint1.socialmeli.exceptions.InvalidParamsException;
import sprint1.socialmeli.exceptions.UserNotFound;
import sprint1.socialmeli.model.User;
import sprint1.socialmeli.repository.ISocialMeliRepository;
import sprint1.socialmeli.utils.UserConverter;

import java.util.Comparator;
import java.util.List;

@Service
public class SocialMeliService implements ISocialMeliService {

    ISocialMeliRepository repository;
    UserConverter userConverter;

    public SocialMeliService(ISocialMeliRepository repository, UserConverter converter) {
        this.repository = repository;
        this.userConverter = converter;
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
        User user1 = getUserFromRepositoryById(userID);
        return new ResponseFollowersCountDTO(user1);
    }

    @Override
    public ResponseFollowersListDTO listFollowers(Integer userId, String order) {
        User user = getUserFromRepositoryById(userId);

        if (order !=  null) {
            checkOrderParam(order);
            sortListOfUsers(user.getListOfFollowers(), order);
        }
        return new ResponseFollowersListDTO( user, userConverter.createFromEntities(user.getListOfFollowers()));
    }

    @Override
    public ResponseFollowedListDTO listFollowed(Integer userId, String order) {
        User user = getUserFromRepositoryById(userId);
        if (order !=  null) {
            checkOrderParam(order);
            sortListOfUsers(user.getListOfFollowed(), order);
        }
        return new ResponseFollowedListDTO( user, userConverter.createFromEntities(user.getListOfFollowed()) );
    }

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
     * Comprueba que el parámetro order sea correcto.
     * @param order orden a aplicar. Los parámetros admitidos son name_asc y name_desc.
     * @throws InvalidParamsException en caso de que el tipo de orden ingresado sea incorrecto.
     */
    private static void checkOrderParam(String order) {
        if (!(order.equalsIgnoreCase("name_asc") || order.equalsIgnoreCase("name_desc"))) {
            throw new InvalidParamsException("Los parámetros ingresados son incorrectos. Este endpoint admite solo:\n" +
                    "order=name_asc\n" +
                    "order=name_desc");
        }
    }

    /**
     * Recibe una lista de User y una String de ordenamiento y ordena la lista acorde al orden.
     * @param users Lista de usuarios a ordenar.
     * @param order orden a aplicar. Los parámetros admitidos son name_asc y name_desc.
     * @return List<User> la lista ordenada
     */
    private void sortListOfUsers(List<User> users, String order) {

        users.sort(Comparator.comparing(User::getName));
        if (order.equals("name_desc")) {
            users.sort(Comparator.comparing(User::getName).reversed());
        }
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
