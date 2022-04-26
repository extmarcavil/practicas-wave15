package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
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
    public ResCountFollowersDTO countFollowers(int userId) {
        User user = userRepository.findById(userId);

        int cantFollowers = userRepository.cantFollowers(userId);

        return new ResCountFollowersDTO(userId,user.getName(),cantFollowers);
    }
}
