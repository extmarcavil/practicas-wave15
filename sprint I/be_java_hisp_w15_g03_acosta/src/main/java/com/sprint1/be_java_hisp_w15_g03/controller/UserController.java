package com.sprint1.be_java_hisp_w15_g03.controller;

import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerFListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.UserListDTO;
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
     * Controller para US: 0001
     * @param userId
     * @param userIdToFollow
     * @return HttpStatus.OK (Status Code 200 ok)
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    ResponseEntity<HttpStatus> followSeller(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        userService.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Controller para US: 0002
     * @param userId
     * @return SellerCountDTO
     */
    @GetMapping("/{userId}/followers/count")
    ResponseEntity<SellerCountDTO> getFollowersCount(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    /**
     * Controller para US: 0003 y 0008
     * @param userId
     * @param order
     * @return SellerFListDTO
     */
    @GetMapping("/{userId}/followers/list")
    ResponseEntity<SellerFListDTO> getFollowersList(@PathVariable Integer userId ,
                                                    @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    /**
     * Controller para US: 0004 y 0008
     * @param userId
     * @param order
     * @return UserListDTO
     */
    @GetMapping("/{userId}/followed/list")
    ResponseEntity<UserListDTO> getFollowedList(@PathVariable Integer userId,
                                                @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

    /**
     * Controller para US: 0007
     * @param userId
     * @param userIdToUnfollow
     * @return HttpStatus.OK (Status Code 200 ok)
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    ResponseEntity<HttpStatus> unFollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        userService.unFollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
