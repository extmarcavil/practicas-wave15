package com.bootcamp.be_java_hisp_w15_g02.controller;


import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowedByUserDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersCountDTO;
import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersBySellerDTO;
import com.bootcamp.be_java_hisp_w15_g02.service.IUserService;
import com.bootcamp.be_java_hisp_w15_g02.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.follow(userId, userIdToFollow);
        return ResponseEntity.ok("Seguidor añadido");
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<GetFollowersCountDTO> getFollowersCountById(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<GetFollowersBySellerDTO> getFollowersBySeller(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowersBySeller(userId, order), HttpStatus.OK);
    }

    /*@GetMapping("/{userId}/followers/list")
    public ResponseEntity<GetFollowersBySellerDTO> getFollowersBySellerOrder(@PathVariable int userId, @RequestParam String order){
        return new ResponseEntity<>( userService.getFollowersBySellerOrder(userId, order), HttpStatus.OK);
    }*/

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<GetFollowedByUserDTO> getFollowersByUser(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowedByUser(userId), HttpStatus.OK);
    }
}
