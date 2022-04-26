package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {


    private final ModelMapper modelMapper;

    private final UserRepository users;



    public UserService(UserRepository users, ModelMapper modelMapper) {
        this.users = users;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserWithFollowersCountDTO getUsersWithFollowersCount(int userID){
            User user = users.getUserById(userID).orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado"));
            UserWithFollowersCountDTO userDTO = modelMapper.map(user, UserWithFollowersCountDTO.class);
            userDTO.setFollowers_count(user.getFollowers().size());
            return userDTO;
    }


    @Override
    public UserDTO convertToDTo(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }
}
