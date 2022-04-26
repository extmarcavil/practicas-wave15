package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowedDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void follow(Integer userId, Integer userToFollow) {
        userRepository.follow(userId,userToFollow);
    }

    @Override
    public void unfollow(Integer userId, Integer userToUnfollow) {
        userRepository.unfollow(userId,userToUnfollow);
    }

    @Override
    public UserCountFollowersDTO getCountFollowers(Integer id) {
        User userSeller = this.userRepository.getUser(id);

        UserCountFollowersDTO userCountFollowersDTO = new UserCountFollowersDTO(userSeller.getId(),
                userSeller.getName(),
                userSeller.getFollowers().size());

        return userCountFollowersDTO;
    }

    @Override
    public UserFollowersDTO getFollowers(Integer id, String order) {
        User userSeller = this.userRepository.getUser(id);
        List<UserDTO> followers = new ArrayList<>();
        if(userSeller.getFollowers() != null) {
            followers = userSeller.getFollowers().stream()
                    .map(x -> new UserDTO(x.getId(), x.getName()))
                    .collect(Collectors.toList());

        }

        if(order == null)
            order = "";

        if(order.equals("name_asc"))
            followers.sort(Comparator.comparing(UserDTO::getUser_name));
        else if (order.equals("name_desc"))
            followers.sort(Comparator.comparing(UserDTO::getUser_name).reversed());

        UserFollowersDTO userFollowersDTO = new UserFollowersDTO(userSeller.getId(), userSeller.getName(), followers);

        return userFollowersDTO;

    }

    @Override
    public UserFollowedDTO getFollowed(Integer id, String order) {
        User user = this.userRepository.getUser(id);
        List<UserDTO> followed = new ArrayList<>();
        if(user.getFollowed() != null) {
            followed = user.getFollowed().stream()
                    .map(x -> new UserDTO(x.getId(), x.getName()))
                    .collect(Collectors.toList());

        }

        if(order == null)
            order = "";

        if(order.equals("name_asc"))
            followed.sort(Comparator.comparing(UserDTO::getUser_name));
        else if (order.equals("name_desc"))
            followed.sort(Comparator.comparing(UserDTO::getUser_name).reversed());

        UserFollowedDTO userFollowedDTO = new UserFollowedDTO(user.getId(), user.getName(), followed);

        return userFollowedDTO;
    }

}
