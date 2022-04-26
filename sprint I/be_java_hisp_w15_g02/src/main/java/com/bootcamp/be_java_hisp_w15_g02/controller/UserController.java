package com.bootcamp.be_java_hisp_w15_g02.controller;

import com.bootcamp.be_java_hisp_w15_g02.service.IUserService;
import com.bootcamp.be_java_hisp_w15_g02.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

}
