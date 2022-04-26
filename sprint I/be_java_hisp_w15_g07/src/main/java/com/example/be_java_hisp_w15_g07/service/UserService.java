package com.example.be_java_hisp_w15_g07.service;


import com.example.be_java_hisp_w15_g07.dto.FollowersCountDTO;

import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.model.User;

import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private IUserRepository userRepository;

    private ModelMapper modelMapper;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();


    }

    public FollowersCountDTO followersCount(Integer idUser){

        User user = userRepository.findById(idUser);
        FollowersCountDTO followers = new FollowersCountDTO(user.getFollowers().size(), user.getUserName(), user.getUserId());
        return  followers;
    }

    @Override
    public void followUser(Integer userId, Integer userToFollowId) {
        User user = userRepository.findById(userId);
        User userToFollow = userRepository.findById(userToFollowId);
        if(userToFollow.getPosts().isEmpty()){
            throw new BadRequestException("No se puede seguir un usuario que no es vendedor");
        }
        if(userId.equals(userToFollowId)){
            throw new BadRequestException("No se puede seguir a si mismo");
        }
        if(!user.addUserToFollow(userToFollow.getUserId())){
            throw new BadRequestException("Ya estas siguiendo a este usuario.");
        }
        if(!userToFollow.addFollower(user.getUserId())){
            throw new BadRequestException("Ya estas seguido por este usuario.");
        }
    }
}
