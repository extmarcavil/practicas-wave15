package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import org.springframework.stereotype.Service;

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
    public ResListFollowersDTO getListFollowers(int userId) {
        User user = userRepository.followersList(userId)
                .orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con id: " + userId));
        List<UserDTO> followers = getListUserDTO(user.getSeguidores());
        return new ResListFollowersDTO(user.getUserId(), user.getName(), followers);

    }

    public ResCountFollowersDTO countFollowers(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));

        int cantFollowers = userRepository.cantFollowers(user);

        return new ResCountFollowersDTO(userId, user.getName(), cantFollowers);
    }

    @Override
    public ResListSellersDTO getListSellers(int userId) {
        User user = userRepository.sellersList(userId)
                .orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con id: " + userId));

        List<UserDTO> followed = getListUserDTO(user.getSeguidos());
        return new ResListSellersDTO(user.getUserId(), user.getName(), followed);
    }

    private List<UserDTO> getListUserDTO(List<User> users) {
        return users.stream().map(u -> new UserDTO(u.getUserId(), u.getName())).collect(Collectors.toList());
    }

}
