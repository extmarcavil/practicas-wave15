package com.sprint1.be_java_hisp_w15_g4.service;

import com.sprint1.be_java_hisp_w15_g4.dto.UserDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowingListDTO;
import com.sprint1.be_java_hisp_w15_g4.exception.*;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    IUserRepository repo;

    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void follow(int userID, int userIDToFollow) {
        if(userID == userIDToFollow)
            throw new EqualsIDException(userID);

        User seguidor = getUser(userID);
        User seguido = getUser(userIDToFollow);

        if (!seguidor.getFollowing().contains(seguido) ){
            seguido.addFollower(seguidor);
            seguidor.addFollowing(seguido);
        } else throw new AlreadyFollowing(userID,userIDToFollow);
    }

    @Override
    public FollowerCountDTO countFollowers(int userID) {
        User user = getUser(userID);
        return new FollowerCountDTO(user.getUser_id(),user.getUser_name(),user.getFollowers().size());
    }

    private User getUser(int userID) {
        User user = repo.findUser(userID);
        if (user == null)
            throw new IDNotFoundException(userID);
        return user;
    }

    @Override
    public FollowerListDTO listFollowers(int userID,String order) {
        User user = getUser(userID);

        FollowerListDTO retorno= new FollowerListDTO(user.getUser_id(),user.getUser_name(),
                user.getFollowers().stream()
                .map(user1 -> new UserDTO(user1.getUser_id(),user1.getUser_name()))
                .collect(Collectors.toList())
        );
        orderByName(order, retorno.getFollowers());
        return retorno;
    }

    @Override
    public FollowingListDTO listFollowing(int userID, String order) {
        FollowingListDTO followingsDTO = new FollowingListDTO();
        List<UserDTO> userDTO = new ArrayList<>();

        User user = getUser(userID);

        followingsDTO.setUser_id(user.getUser_id());
        followingsDTO.setUser_name(user.getUser_name());

        // Usar Mapper
        for (User u : user.getFollowing()) {
            userDTO.add(new UserDTO(u.getUser_id(), u.getUser_name()));
        }

        orderByName(order, userDTO);

        followingsDTO.setFollowed(userDTO);

        return followingsDTO;
    }

    private void orderByName(String order, List<UserDTO> userDTO) {
        if (order == null || order.equals("name_asc"))
            userDTO.sort(Comparator.comparing(UserDTO::getUser_name));
        else if (order.equals("name_desc"))
            userDTO.sort(Comparator.comparing(UserDTO::getUser_name).reversed());
        else
            throw new BadOrderArgumentExcepcion(order);
    }

    @Override
    public void unfollow(int userID, int userIDToUnfollow) {
        if(userID == userIDToUnfollow)
            throw new EqualsIDException(userID);

        User user = getUser(userID);
        User userToUnfollow = getUser(userIDToUnfollow);

        if(!user.getFollowing().contains(userToUnfollow)){
            throw new NotFollowException(userIDToUnfollow);
        }

        user.removeFollowing(userToUnfollow);
        userToUnfollow.removeFollower(user);
    }
}
