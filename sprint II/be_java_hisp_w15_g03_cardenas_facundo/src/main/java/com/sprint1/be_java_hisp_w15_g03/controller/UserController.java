package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
import com.sprint1.be_java_hisp_w15_g03.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<HttpStatus> followSeller(@PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") Integer userId,
                                            @PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") Integer userIdToFollow) {
        userService.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    ResponseEntity<SellerCountDTO> getFollowersCount(@PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") Integer userId) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    ResponseEntity<SellerFListDTO> getFollowersList(@PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") Integer userId ,
                                                    @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    ResponseEntity<UserListDTO> getFollowedList(@PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") Integer userId,
                                                @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<HttpStatus> unFollowSeller(@PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") Integer userId,
                                              @PathVariable @Min(value = 1, message = "El id debe ser mayor a cero.") Integer userIdToUnfollow){
        userService.unFollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
