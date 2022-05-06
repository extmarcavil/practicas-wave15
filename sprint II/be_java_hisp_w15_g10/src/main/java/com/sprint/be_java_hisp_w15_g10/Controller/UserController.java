package com.sprint.be_java_hisp_w15_g10.Controller;


import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Service.IUserService;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.VendedorsFollowedDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RequestMapping("users/")
@RestController
@Validated
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<UserWithFollowersCountDTO> getUserWitFollowersCount (
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userId) {
        return new ResponseEntity<UserWithFollowersCountDTO>(userService.getUsersWithFollowersCount(userId), HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UnfollowUserDTO> unfollowUser(
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userId,
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userIdToUnfollow){
        return new ResponseEntity<UnfollowUserDTO>(userService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getUserFollowers(
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userId,
            @Pattern(regexp = "^(name_asc)$|^(name_desc)$") @RequestParam(defaultValue = "name_asc") String order){
        return new ResponseEntity<FollowersDTO>(userService.getFollowers(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowUserDTO> followUser(
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userId,
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userIdToFollow){
        return   new ResponseEntity<FollowUserDTO>(userService.followUser(userId, userIdToFollow),HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param order
     * @return
     */

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<VendedorsFollowedDTO> getVendorsFollow(
            @Min(value = 1, message = "El id debe ser mayor a cero") @PathVariable int userId,
            @Pattern(regexp = "^(name_asc)$|^(name_desc)$") @RequestParam(defaultValue = "name_asc") String order) {
        return new ResponseEntity<>(userService.getVendorsFollow(userId, order), HttpStatus.OK);
    }

}
