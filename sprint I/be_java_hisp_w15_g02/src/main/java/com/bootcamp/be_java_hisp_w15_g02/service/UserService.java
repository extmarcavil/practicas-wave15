package com.bootcamp.be_java_hisp_w15_g02.service;

import com.bootcamp.be_java_hisp_w15_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g02.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
