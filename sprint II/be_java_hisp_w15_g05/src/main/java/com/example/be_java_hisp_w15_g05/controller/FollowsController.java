package com.example.be_java_hisp_w15_g05.controller;

import com.example.be_java_hisp_w15_g05.service.IFollowsService;
import com.example.be_java_hisp_w15_g05.dto.ResCountFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListFollowersDTO;
import com.example.be_java_hisp_w15_g05.dto.ResListSellersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/users")
@Validated
public class FollowsController {
    private IFollowsService userService;
    protected static final String userIDNotNull= "El  id no puede estar vacío.";
    protected static final String userIDPositive="El id debe ser mayor a cero";

    public FollowsController(IFollowsService userService) {

        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity follow(
            @Positive(message =userIDPositive)
            @NotNull(message = userIDNotNull)
            @PathVariable int userId,
            @Positive(message =userIDPositive)
            @NotNull(message = userIDNotNull)
            @PathVariable int userIdToFollow) {

        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unFollow(
            @Positive(message =userIDPositive)
            @NotNull(message = userIDNotNull)
            @PathVariable int userId,
            @Positive(message =userIDPositive)
            @NotNull(message = userIDNotNull)
            @PathVariable int userIdToUnfollow) {

        return new ResponseEntity<>(userService.unFollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<ResCountFollowersDTO> countFollowers(
            @Positive(message =userIDPositive)
            @NotNull(message = userIDNotNull)
            @PathVariable int userId) {

        return new ResponseEntity<>(userService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")

    public ResponseEntity<ResListFollowersDTO> getListFollowers(
            @Positive(message =userIDPositive)
            @NotNull(message = userIDNotNull)
            @PathVariable int userId,
            @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(userService.getListFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResListSellersDTO> getListFollowed(
            @Positive(message =userIDPositive)
            @NotNull(message = userIDNotNull)
            @PathVariable int userId,

            @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(userService.getListSellers(userId, order), HttpStatus.OK);
    }

}
