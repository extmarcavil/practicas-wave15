package com.example.be_java_hisp_w15_g07.controller;

import com.example.be_java_hisp_w15_g07.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }
}
