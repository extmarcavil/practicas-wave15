package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResFollowPostDTO follow(int userId, int userToFollowId) {
        return null;
    }

    @Override
    public List<ResListFollowersDTO> getListFollowers(int userId) {
        userRepository.followersList(userId).orElse(throw new UserNotFoundException("No se encontró el usuario "))

        return null;
    }


}
