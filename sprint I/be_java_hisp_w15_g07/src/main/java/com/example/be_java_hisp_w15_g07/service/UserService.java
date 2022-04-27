package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowersDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.model.User;

import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public FollowersDTO getFollowersList(Integer userId) {
        User user = userRepository.getFollowersList(userId);
        FollowersDTO followers = modelMapper.map(user, FollowersDTO.class);
        List<UserFollowersDTO> userFollowers = user.getFollowers().stream()
                .map(v -> modelMapper.map(userRepository.findById(v.getUserId()), UserFollowersDTO.class))
                .collect(Collectors.toList());
        followers.setFollowers(userFollowers);
        return followers;
    }

    @Override
    public FollowedDTO getFollowedList(Integer userId) {
        User user = userRepository.findById(userId);
        FollowedDTO followed = modelMapper.map(user, FollowedDTO.class);
        List<UserFollowersDTO> userFollowed = user.getFollowed().stream()
                .map(v -> modelMapper.map(userRepository.findById(v.getUserId()), UserFollowersDTO.class))
                .collect(Collectors.toList());
        followed.setFollowed(userFollowed);
        return followed;
    }

    public FollowersCountDTO followersCount(Integer idUser){
        User user = userRepository.findById(idUser);
        FollowersCountDTO followers = new FollowersCountDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
        return  followers;
    }

    @Override
    public void followUser(Integer userId, Integer userToFollowId) {
        User user = userRepository.findById(userId);
        User userToFollow = userRepository.findById(userToFollowId);
        if(userToFollow.getPosts().isEmpty()){
            throw new BadRequestException("No se puede seguir un usuario que no es vendedor.");
        }
        if(userId.equals(userToFollowId)){
            throw new BadRequestException("No se puede seguir a si mismo.");
        }
        if(!user.addUserToFollow(userToFollow)){
            throw new BadRequestException("Ya estas siguiendo a este usuario.");
        }
        if(!userToFollow.addFollower(user)){
            throw new BadRequestException("Ya estas seguido por este usuario.");
        }
    }

    @Override
    public void unfollowUser(Integer userId, Integer userToUnfollowId) {
        User user = userRepository.findById(userId);
        User userToUnfollow = userRepository.findById(userToUnfollowId);

        if(userId.equals(userToUnfollowId)){
            throw new BadRequestException("No se puede dejar de seguir a si mismo.");
        }
        boolean unfollow = user.getFollowed().removeIf(u -> u.getUserId().equals(userToUnfollowId)) && userToUnfollow.getFollowers().removeIf(u -> u.getUserId().equals(userId));;
        if (!unfollow){
            throw new BadRequestException("Este usuario no sigue a este vendedor.");
        }
    }
}
