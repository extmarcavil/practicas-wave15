package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.UserDTO;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResFollowPostDTO follow(int userId, int userToFollowId) {
        userRepository.findById(userId);
        return null;
    }

    @Override
    public ResListFollowersDTO getListFollowers(int userId) {
        User user = userRepository.followersList(userId)
                .orElseThrow(() -> new UserNotFoundException("No se encontró el usuario con id: " + userId));
        List<UserDTO> followers = getListUserDTO(user.getSeguidores());
        return new ResListFollowersDTO(user.getUserId(), user.getName(), followers);

    }

    public ResCountFollowersDTO countFollowers(int userId) {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new UserNotFoundException("Usuario " + userId + " no encontrado.");
        }

        int cantFollowers = userRepository.cantFollowers(userId);

        return new ResCountFollowersDTO(userId, user.getName(), cantFollowers);
    }

    private List<UserDTO> getListUserDTO(List<User> users) {
        return users.stream().map(u -> new UserDTO(u.getUserId(), u.getName())).collect(Collectors.toList());
    }

}
