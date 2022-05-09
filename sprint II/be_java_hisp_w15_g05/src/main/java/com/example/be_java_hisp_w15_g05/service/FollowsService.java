package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.*;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowsService implements IFollowsService {

    private IUserRepository userRepository;

    public FollowsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResFollowPostDTO follow(int userId, int userToFollowId) {
        User follower = validateUserExists(userId);
        User toFollow = validateUserExists(userToFollowId);
        validateIsSeller(toFollow);
        validateUserAlreadyFollowed(follower, toFollow);
        validateUserCannotFollowHimself(follower, toFollow);

        userRepository.follow(follower, toFollow);

        return new ResFollowPostDTO("Usuario " + userToFollowId + " seguido con éxito");
    }

    @Override
    public ResFollowPostDTO unFollow(int userId, int userToUnfollowId) {

        User follower = validateUserExists(userId);
        User toFollow = validateUserExists(userToUnfollowId);
        validateUserIsFollower(follower, toFollow);

        userRepository.unFollow(follower, toFollow);

        return new ResFollowPostDTO("Usuario " + userToUnfollowId + " dejado de seguir");
    }

    @Override
    public ResListFollowersDTO getListFollowers(int userId, String order) {
        checkSortName(order);

        User user = validateUserExists(userId);

        List<UserDTO> followers = getListUserDTO(user.getSeguidores());

        sortListByName(followers, order);

        return new ResListFollowersDTO(user.getUserId(), user.getName(), followers);
    }

    public ResCountFollowersDTO countFollowers(int userId) {
        User user = validateUserExists(userId);

        int cantFollowers = userRepository.cantFollowers(user);

        return new ResCountFollowersDTO(userId, user.getName(), cantFollowers);
    }

    @Override
    public ResListSellersDTO getListSellers(int userId, String order) {
        checkSortName(order);

        User user = validateUserExists(userId);

        List<UserDTO> followed = getListUserDTO(user.getSeguidos());

        sortListByName(followed, order);

        return new ResListSellersDTO(user.getUserId(), user.getName(), followed);
    }

    /**
     * Mapear de Lista de User a Lista de UserDTO
     * @param users lista de usuarios
     * @return
     */
    private List<UserDTO> getListUserDTO(List<User> users) {
        return users.stream().map(u -> new UserDTO(u.getUserId(), u.getName())).collect(Collectors.toList());
    }

    /**
     * Verifica que el usuario exista en el repositorio o lanza UserNotFoundException
     * @param userId id de un usuario
     * @return
     */
    private User validateUserExists(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));
    }

    /**
     * Verifica que el usuario sea un vendedor o lanza UserNotSellerException
     * @param user usuario
     */
    private void validateIsSeller(User user) {
        if(!user.isSeller())
            throw new UserNotSellerException("El usuario " + user.getUserId() + " no es un vendedor");
    }

    /**
     * Si el usuario ya sigue al vendedor lanza UserAlreadyFollowedException
     * @param follower usuario seguidor
     * @param seller usuario vendedor o a seguir
     */
    private void validateUserAlreadyFollowed(User follower, User seller) {
        if(seller.getSeguidores().contains(follower))
            throw new UserAlreadyFollowedException("No se puede seguir: El usuario " + follower.getUserId() +
                    " actualmente ya es un seguidor del usuario " + seller.getUserId());
    }

    /**
     * Verifica que un usuario no se siga a si mismo lanzando UserCannotFollowHimself
     * @param follower usuario seguidor
     * @param seller usuario vendedor o a seguir
     */
    private void validateUserCannotFollowHimself(User follower, User seller) {
        if(seller.getUserId() == follower.getUserId())
            throw new UserCannotFollowHimself("Un usuario no se puede seguir a sí mismo");
    }

    /**
     * Lanza UserNotFollowingException si el usuario NO seguia al vendedor
     * @param follower seguidor
     * @param seller vendedor a dejar de seguir
     */
    private void validateUserIsFollower(User follower, User seller) {
        if(!seller.getSeguidores().contains(follower))
            throw new UserNotFollowingException("No se pudo dejar de seguir: El usuario " + follower.getUserId() +
                    " no sigue actualmente al usuario " + seller.getUserId());
    }

    /**
     * Recibe una lista de UserDTO y la ordena seguin el parametro 'order'
     *
     * Por defecto ordena de manera asc
     *
     * @param list Lista de UserDTO
     * @param order condición de ordenamiento
     */
    private void sortListByName(List<UserDTO> list, String order) {
        if(order.equalsIgnoreCase("name_desc"))
            list.sort(Comparator.comparing(UserDTO::getUserName).reversed());
        else
            list.sort(Comparator.comparing(UserDTO::getUserName));
    }

    /**
     * Verificar que sea una condición de ordenamiento valida o lanza OrderNotValidException
     * @param order condición de ordenamiento
     */
    private void checkSortName(String order){
        if(!order.equals("name_asc") && !order.equals("name_desc") && !order.isEmpty())
            throw new OrderNotValidException("El ordenamiento " + order + " no existe.");

    }
}
