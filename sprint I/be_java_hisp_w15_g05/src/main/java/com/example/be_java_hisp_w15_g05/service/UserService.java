package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResFollowPostDTO;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ResFollowPostDTO> follow(int userId, int userToFollowId) {

        boolean resultado = userRepository.follow(userId, userToFollowId);
        if(resultado){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResCountFollowersDTO countFollowers(int userId) {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        int cantFollowers = userRepository.cantFollowers(userId);

        return new ResCountFollowersDTO(userId, user.getName(), cantFollowers);
    }
}
