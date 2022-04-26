package com.example.be_java_hisp_w15_g07.service;

import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        ModelMapper modelMapper = new ModelMapper();
    }
}
