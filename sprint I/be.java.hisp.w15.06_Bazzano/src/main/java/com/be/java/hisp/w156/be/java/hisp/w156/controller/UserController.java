package com.be.java.hisp.w156.be.java.hisp.w156.controller;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserCountFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowedDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.UserFollowersDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    //Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<SuccessDTO> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return userService.follow(userId, userIdToFollow);
    }

    //Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        userService.unfollow(userId,userIdToUnfollow);
    }

    //Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserCountFollowersDTO> getCountFollow(@PathVariable Integer userId){
        UserCountFollowersDTO userCountFollowersDTO = userService.getCountFollowers(userId);
        return new ResponseEntity<>(userCountFollowersDTO, HttpStatus.OK);
    }

    //Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getFollowers(@PathVariable Integer userId, @RequestParam(required=false, defaultValue = "") String order){
        UserFollowersDTO userFollowersDTO = userService.getFollowers(userId, order);
        return new ResponseEntity<>(userFollowersDTO, HttpStatus.OK);
    }

    //Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable Integer userId, @RequestParam(required=false, defaultValue = "") String order){
        UserFollowedDTO userFollowedDTO = userService.getFollowed(userId, order);
        return new ResponseEntity<>(userFollowedDTO, HttpStatus.OK);
    }
}
