package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFollowingException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotSellerException;
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

        User follower = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));

        User toFollow = userRepository.findById(userToFollowId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userToFollowId + " no encontrado."));;

        boolean resultado = userRepository.follow(follower, toFollow);

        if(!resultado){
            throw new UserNotSellerException("El usuario " + userToFollowId + " no es un vendedor");
        }
        return new ResFollowPostDTO("Usuario " + userToFollowId + " seguido con éxito");
    }

    @Override
    public ResFollowPostDTO unFollow(int userId, int userToUnfollowId) {

        User follower = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));

        User toFollow = userRepository.findById(userToUnfollowId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userToUnfollowId + " no encontrado."));;

        boolean resultado = userRepository.unFollow(follower, toFollow);

        if(!resultado){
            throw new UserNotFollowingException("No se pudo dejar de seguir: El usuario " + userId +
                    " no sigue actualmente al usuario " + userToUnfollowId + ", o éste último no es un vendedor");
        }
        return new ResFollowPostDTO("Usuario " + userToUnfollowId + " dejado de seguir");
    }

    @Override
    public ResListFollowersDTO getListFollowers(int userId, String order) {

        User user = userRepository.followersList(userId)
                .orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con id: " + userId));
        List<UserDTO> followers = getListUserDTO(user.getSeguidores());
        if(order!=null && order.equals("name_desc")){
            followers.sort(Comparator.comparing(UserDTO::getUserName).reversed());
        }else{
            followers.sort(Comparator.comparing(UserDTO::getUserName));
        }

        return new ResListFollowersDTO(user.getUserId(), user.getName(), followers);

    }

    @Override
    public ResCountFollowersDTO countFollowers(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));

        int cantFollowers = userRepository.cantFollowers(user);

        return new ResCountFollowersDTO(userId, user.getName(), cantFollowers);
    }

    @Override
    public ResListSellersDTO getListSellers(int userId, String order) {
        User user = userRepository.sellersList(userId)
                .orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con id: " + userId));
        List<UserDTO> followed = getListUserDTO(user.getSeguidos());

       if( order!=null && order.equals("name_desc")){
            followed.sort(Comparator.comparing(UserDTO::getUserName).reversed());
        }else{
            followed.sort(Comparator.comparing(UserDTO::getUserName));
        }

        return new ResListSellersDTO(user.getUserId(), user.getName(), followed);
    }

    private List<UserDTO> getListUserDTO(List<User> users) {
        return users.stream().map(u -> new UserDTO(u.getUserId(), u.getName())).collect(Collectors.toList());
    }

}
