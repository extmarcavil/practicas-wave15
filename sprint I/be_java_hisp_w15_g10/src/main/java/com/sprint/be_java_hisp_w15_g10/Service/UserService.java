package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Response.FollowUserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UnfollowUserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.Exception.FollowException;
import com.sprint.be_java_hisp_w15_g10.Exception.NotFollowException;
import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.VendedorsFollowedDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserService(UserRepository users, ModelMapper modelMapper) {
        this.userRepository = users;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserWithFollowersCountDTO getUsersWithFollowersCount(int userID){
            User user = userRepository.getById(userID)
                    .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado"));
            UserWithFollowersCountDTO userDTO = modelMapper.map(user, UserWithFollowersCountDTO.class);
            userDTO.setFollowers_count(user.getFollowers().size());
            return userDTO;
    }

    @Override
    public UnfollowUserDTO unfollowUser(int userId, int userIdToUnfollow){
        User user = userRepository.getById(userId)
                .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado"));
        User userToUnfollow = userRepository.getById(userIdToUnfollow)
                .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado"));

        if(!user.getFollowed().contains(userToUnfollow)){
            throw new NotFollowException("Usted no sigue a: " +userToUnfollow.getUser_name());
        }

        user.dejarDeSeguir(userToUnfollow);
        userToUnfollow.eliminarSeguidor(user);
        return new UnfollowUserDTO("Se ha dejado de seguir al usuario: "+userToUnfollow.getUser_name());
    }

    @Override
    public FollowUserDTO followUser(int userId, int userIdToUnfollow){
        User user = userRepository.getById(userId)
                .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado"));
        User userToUnfollow = userRepository.getById(userIdToUnfollow)
                .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado"));

        if(user.getFollowed().contains(userToUnfollow)){
            throw new FollowException("Usted ya sigue a: " +userToUnfollow.getUser_name());
        }

        user.seguirUsuario(userToUnfollow);
        userToUnfollow.agregarSeguidor(user);
        return new FollowUserDTO("Se ha comenzado a seguir al usuario: "+userToUnfollow.getUser_name());
    }

    @Override
    public VendedorsFollowedDTO getVendorsFollow(int userId) {
        User user = userRepository.getById(userId).get();
        VendedorsFollowedDTO vendedorsFollowedDTO = new VendedorsFollowedDTO();
        List<UserDTO> listUsers = new ArrayList<>();

        user.getFollowers().forEach(u -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setUser_id(u.getUser_id());
            userDTO.setUser_name(u.getUser_name());
            listUsers.add(userDTO);
        });

        vendedorsFollowedDTO.setFollowed(listUsers);
        vendedorsFollowedDTO.setUserId(user.getUser_id());
        vendedorsFollowedDTO.setUserName(user.getUser_name());
        return vendedorsFollowedDTO;
    }
}
