package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.UserCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Exception.DuplicatedEntityException;
import com.sprint.be_java_hisp_w15_g10.Exception.FollowException;
import com.sprint.be_java_hisp_w15_g10.Exception.NotFollowException;
import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final Utils utils;

    public UserService(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserWithFollowersCountDTO getUsersWithFollowersCount(int userID){
            User user = utils.getUserOrThrow(userID);
            UserWithFollowersCountDTO userDTO = utils.getUserUtils().convertToDto(user, new UserWithFollowersCountDTO());
            userDTO.setFollowers_count(user.getFollowers().size());
            return userDTO;
    }

    @Override
    public UserWithPromoPostCountDTO getUsersWithPromoPostCount(int userID) {
        User user = utils.getUserOrThrow(userID);
        UserWithPromoPostCountDTO userDTO = utils.getUserUtils().convertToDto(user, new UserWithPromoPostCountDTO());
        userDTO.setPromo_products_count((int) user.getPosts().stream().filter(Post::isHas_promo).count());
        return userDTO;
    }

    @Override
    public UnfollowUserDTO unfollowUser(int userId, int userIdToUnfollow){
        User user = utils.getUserOrThrow(userId);
        User userToUnfollow = utils.getUserOrThrow(userIdToUnfollow);
        if(!user.getFollowed().contains(userToUnfollow)) throw new NotFollowException("Usted no sigue a: " + userToUnfollow.getUser_name());
        user.dejarDeSeguir(userToUnfollow);
        userToUnfollow.eliminarSeguidor(user);
        return new UnfollowUserDTO("Se ha dejado de seguir al usuario: " + userToUnfollow.getUser_name());
    }

    @Override
    public FollowUserDTO followUser(int userId, int userIdToFollow){
        User user = utils.getUserOrThrow(userId);
        User userToUnfollow = utils.getUserOrThrow(userIdToFollow);
        if(user.getFollowed().contains(userToUnfollow)) throw new FollowException("Usted ya sigue a: " + userToUnfollow.getUser_name());
        user.seguirUsuario(userToUnfollow);
        userToUnfollow.agregarSeguidor(user);
        return new FollowUserDTO("Se ha comenzado a seguir al usuario: " + userToUnfollow.getUser_name());
    }

    @Override
    public UserWithFollowedUsersDTO getUsersWithFollowers(int userId, String order) {
        User user = utils.getUserOrThrow(userId);
        UserWithFollowedUsersDTO userWithFollowedUsersDTO = utils.getUserUtils().convertToDto(user, new UserWithFollowedUsersDTO());
        List<User> listUsers = user.getFollowed();
        if(order.equals("name_asc")) listUsers.sort(Comparator.comparing(User::getUser_name));
        else if(order.equals("name_desc")) listUsers.sort((user1, user2) -> user2.getUser_name().compareTo(user1.getUser_name()));
        userWithFollowedUsersDTO.setFollowed(utils.getUserUtils().convertToListOfDTO(listUsers, new UserDTO()));
        return userWithFollowedUsersDTO;
    }

    @Override
    public FollowersDTO getFollowers(int userId, String order) {
        User user = utils.getUserOrThrow(userId);
        FollowersDTO followersDTO = utils.getUserUtils().convertToDto(user, new FollowersDTO());
        List<User> listUsers = user.getFollowers();
        if(order.equals("name_asc")) listUsers.sort(Comparator.comparing(User::getUser_name));
        else if(order.equals("name_desc")) listUsers.sort((user1, user2) -> user2.getUser_name().compareTo(user1.getUser_name()));
        followersDTO.setFollowers(utils.getUserUtils().convertToListOfDTO(listUsers, new UserDTO()));
        return followersDTO;
    }

    @Override
    public UserCreatedDTO createUser(UserCreateDTO userCreateDTO) {
        if(utils.getUserUtils().addObject(utils.getUserUtils().convertToEntity(userCreateDTO, new User()),userCreateDTO.getUser_name()))
            return new UserCreatedDTO("Se ha creado el usuario " + userCreateDTO.getUser_name() + " con éxito.");
        throw new DuplicatedEntityException("El usuario con nombre " + userCreateDTO.getUser_name() + " ya se encuentra registrado");
    }

    @Override
    public List<UserDTO> getAll(String order) {
        List<User> users = utils.getUserUtils().getAllObjects();
        if(order.equals("name_asc")) users.sort(Comparator.comparing(User::getUser_name));
        else if(order.equals("name_desc")) users.sort((user1, user2) -> user2.getUser_name().compareTo(user1.getUser_name()));
        return utils.getUserUtils().convertToListOfDTO(users, new UserDTO());
    }
}
