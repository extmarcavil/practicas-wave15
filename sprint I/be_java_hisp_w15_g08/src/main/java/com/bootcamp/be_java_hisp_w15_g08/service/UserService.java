package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.FollowersListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.Post;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    IUserRepository repository;
    ModelMapper mapper;

    public UserService(IUserRepository repository) {
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public FollowersCountDTO countFollers(Integer idUser) {
        User user = repository.findUser(idUser);
        FollowersCountDTO followersCountDTO = new FollowersCountDTO(user.getUserID(), user.getName(), user.getFollowers().size());
        return followersCountDTO;
    }

    @Override
    public FollowersListDTO followersListDTO (Integer idUser){
        User user =repository.findUser(idUser);
        List<UserDTO> listDto = new ArrayList<>();
        user.getFollowers().forEach(user1 -> listDto.add(mapper.map(user1,UserDTO.class)));
        FollowersListDTO followersListDTO = new FollowersListDTO(user.getUserID(),user.getName(),listDto);
        return followersListDTO;
    }

    @Override
    public void addPost(NewPostDTO newPostDTO){
        User user = repository.findUser(newPostDTO.getUser_id());
        Post post = mapper.map(newPostDTO,Post.class);
        user.addPost(post);
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
