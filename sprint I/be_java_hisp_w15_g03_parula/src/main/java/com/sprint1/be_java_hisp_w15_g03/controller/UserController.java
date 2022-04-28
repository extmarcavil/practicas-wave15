package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.response.*;
import com.sprint1.be_java_hisp_w15_g03.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    /**
     * US01
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<HttpStatus> followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        userService.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * US02
     */
    @GetMapping("/{userId}/followers/count")
    ResponseEntity<SellerCountDTO> getFollowersCount(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    /**
     * US03 - US08
     */
    @GetMapping("/{userId}/followers/list")
    ResponseEntity<SellerFListDTO> getFollowersList(@PathVariable Integer userId ,
                                                    @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    /**
     * US04 - US08
     */
    @GetMapping("/{userId}/followed/list")
    ResponseEntity<UserListDTO> getFollowedList(@PathVariable Integer userId,
                                                @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

    /**
     * US07
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<HttpStatus> unFollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        userService.unFollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * US13
     */
    @GetMapping("/sellers")
    ResponseEntity<SellersListDTO> getSellers(){
        return new ResponseEntity<>(userService.getSellers(), HttpStatus.OK);
    }

    /**
     * US14
     */
    @GetMapping("/sellers/{productId}")
    ResponseEntity<SellersPerProdListDTO> getSellersForProduct(@PathVariable Integer productId){
        return new ResponseEntity<>(userService.getSellersProduct(productId), HttpStatus.OK);
    }





}
