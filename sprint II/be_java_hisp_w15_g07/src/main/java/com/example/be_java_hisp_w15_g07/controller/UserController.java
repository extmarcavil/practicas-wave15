package com.example.be_java_hisp_w15_g07.controller;

import com.example.be_java_hisp_w15_g07.dto.response.FollowedDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w15_g07.dto.response.FollowersDTO;
import com.example.be_java_hisp_w15_g07.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


/**
 *  user controller
 *
 */
@RestController
@Validated
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }
    
    /**
     * Count the user followers
     *
     * @param userId Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see FollowersCountDTO
     * @author Jeronimo Martin Graff
     * @author Facundo Chavez del Pino
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> countFollowers(@PathVariable
                                                            @NotNull(message = "El  id no puede estar vacío.")
                                                            @Positive(message = "El id debe ser mayor a cero")
                                                            Integer userId){
        FollowersCountDTO followers = userService.followersCount(userId);
        return new ResponseEntity<>(followers, HttpStatus.OK);
    }


    /**
     * Follow a user
     *
     * @param userId Integer
     * @param userIdToFollow Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @author Tomas Ravelli
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable
                                     @NotNull(message = "El  id no puede estar vacío.")
                                     @Positive(message = "El id debe ser mayor a cero")
                                     Integer userId,
                                     @PathVariable
                                     @NotNull(message = "El  id no puede estar vacío.")
                                     @Positive(message = "El id debe ser mayor a cero")
                                     Integer userIdToFollow){
        userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * get followers list optionally ordered by user
     *
     * @param userId Integer
     * @param order String
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see FollowersDTO
     * @author Wendy Sclerandi
     * @author Sebastian Muchut
     * modified by: Tomas Ravelli & Jeronimo Martin Graff
     */
    //Tomas
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowersList(@PathVariable
                                                         @NotNull(message = "El  id no puede estar vacío.")
                                                         @Positive(message = "El id debe ser mayor a cero")
                                                         Integer userId,
                                                         @RequestParam(defaultValue = "") String order){
        if(order.isBlank()){
            return new ResponseEntity<>(userService.getFollowersList(userId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
        }
    }

    /**
     * get followed list optionally ordered by user
     *
     * @param userId Integer
     * @param order String
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see FollowedDTO
     * @author Facundo Chavez del Pino
     * @author Mauricio Gomez
     * modified by Tomas Ravelli & Jeronimo Martin Graff
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowedList(@PathVariable
                                                       @NotNull(message = "El  id no puede estar vacío.")
                                                       @Positive(message = "El id debe ser mayor a cero")
                                                       Integer userId,
                                                       @RequestParam(defaultValue = "") String order){
        if(order.isBlank()){
            return new ResponseEntity<>(userService.getFollowedList(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
        }
    }

    /**
     * unfollow user
     *
     * @param userId Integer
     * @param userIdToUnfollow Integer
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @author Facundo Chaves del Pino
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollowUser(@PathVariable
                                       @NotNull(message = "El  id no puede estar vacío.")
                                       @Positive(message = "El id debe ser mayor a cero")
                                       Integer userId,
                                       @PathVariable
                                       @NotNull(message = "El  id no puede estar vacío.")
                                       @Positive(message = "El id debe ser mayor a cero")
                                       Integer userIdToUnfollow){
        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
