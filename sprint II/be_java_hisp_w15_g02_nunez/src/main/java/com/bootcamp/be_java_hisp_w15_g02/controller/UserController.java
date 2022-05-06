package com.bootcamp.be_java_hisp_w15_g02.controller;


import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.service.IUserService;
import com.bootcamp.be_java_hisp_w15_g02.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable(value = "userId") @NotNull(message = "El id no puede estar vacio")
                                        @Min(value = 1, message = "El id debe ser mayor a 0") Integer userId,
                                    @PathVariable("userIdToFollow") @NotNull(message = "El id no puede estar vacio")
                                        @Min(value = 1, message = "El id debe ser mayor a 0") Integer userIdToFollow) {
        userService.follow(userId, userIdToFollow);
        return ResponseEntity.ok("Seguidor anadido");
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<GetFollowersCountDTO> getFollowersCountById(@PathVariable @NotNull(message = "El id no puede estar vacio")
                                                                          @Min (value = 1, message = "El id debe ser mayor a 0")Integer userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<GetFollowersBySellerDTO> getFollowersBySeller(@PathVariable @NotNull(message = "El id no puede estar vacio")
                                                                            @Min(value = 1, message = "El id debe ser mayor a 0") Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowersBySeller(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<GetFollowedByUserDTO> getFollowersByUser(@PathVariable @NotNull(message = "El id no puede estar vacio")
                                                                       @Min(value = 1, message = "El id debe ser mayor a 0")
                                                                            Integer userId,
                                                                   @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowedByUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<?> unFollow(@PathVariable @NotNull(message = "El id no puede estar vacio")
                                          @Min(value = 1, message = "El id debe ser mayor a 0") Integer userId,
                                      @PathVariable @NotNull(message = "El id no puede estar vacio")
                                        @Min(value = 1, message = "El id debe ser mayor a 0") Integer userIdToUnFollow) {
        userService.unFollow(userId, userIdToUnFollow);
        return ResponseEntity.ok("Dejo de seguir al usuario: " + userIdToUnFollow);
    }
}
