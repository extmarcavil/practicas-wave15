package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.*;
import com.bootcamp.be_java_hisp_w15_g08.model.Post;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g08.utils.SortUsers;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.stream.Collectors.toList;

@Service
public class UserService implements IUserService{

    IUserRepository repository;
    ModelMapper mapper;
    private int idsPost;

    public UserService(IUserRepository repository) {
        this.repository = repository;
        mapper = new ModelMapper();
        idsPost = 1;
    }

    @Override
    public FollowersCountDTO countFollers(Integer idUser) {
        User user = repository.findUser(idUser);
        FollowersCountDTO followersCountDTO = new FollowersCountDTO(user.getUserID(), user.getName(), user.getFollowers().size());
        return followersCountDTO;
    }

    @Override
    public FollowersListDTO getFollowersList(Integer idUser,String order){
        User user =repository.findUser(idUser);
        List<UserDTO> listDto = user.getFollowers()
                .stream()
                .map(user1 -> mapper.map(user1,UserDTO.class))
                .collect(toList());

        if(order!= null){
            listDto = SortUsers.order(listDto,order);
        }
        FollowersListDTO followersListDTO = new FollowersListDTO(user.getUserID(),user.getName(),listDto);
        return followersListDTO;
    }

    @Override
    public FollowersListDTO getFollowedList(Integer userId,String order) {
        User user =repository.findUser(userId);
        List<UserDTO> listDto = user.getFollowing()
                .stream()
                .map(user1 -> mapper.map(user1,UserDTO.class))
                .collect(toList());
        if(order!= null){
            listDto = SortUsers.order(listDto,order);
        }
        FollowersListDTO followedListDTO = new FollowersListDTO(user.getUserID(),user.getName(),listDto);
        return followedListDTO;
    }



    @Override
    public void  followUser(Integer idFollowed, Integer idFollower){
        repository.followUser(idFollowed,idFollower);
    }

    @Override
    public void unFollowUser(Integer idFollowed, Integer idFollower){
        repository.unFollowUser(idFollowed,idFollower);
    }





}
