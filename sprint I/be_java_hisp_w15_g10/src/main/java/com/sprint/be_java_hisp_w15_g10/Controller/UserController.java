package com.sprint.be_java_hisp_w15_g10.Controller;


import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.UserWithFollowersCountDTO;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RequestMapping("users/")
@RestController
public class UserController {

    @GetMapping("{userId}/followers/count")
    public EntityResponse<UserWithFollowersCountDTO> getUserWitFollowersCount(@PathVariable int userId){
        return null;
    }

    @GetMapping("/{userId}/followers/list")
    public List<UserDTO> getUserFollowers(@PathVariable int userId){


        return null;
    }


    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public EntityResponse followUser(@PathVariable int userId){
        UserService userService = new UserService();
        if (UserService.)
        return   ;
    }

}
