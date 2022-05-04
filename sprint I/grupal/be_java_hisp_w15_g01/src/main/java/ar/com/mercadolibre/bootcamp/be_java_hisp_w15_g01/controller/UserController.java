package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowedListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@valid @PathVariable Long userId, @PathVariable long userIdToFollow) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.follow(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> wowManyFollowsMe(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.wowManyFollowsMe(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> whoFollowsMe(@PathVariable Long userId, @RequestParam(required=false) String order) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.whoFollowsMe(userId, order));

    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> AllFollowedByUserId(@PathVariable Long userId , @RequestParam(required = false) String order){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllFollowedByUserId(userId, order));
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> unFollow(@PathVariable long userId, @PathVariable long userIdToUnfollow){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.unFollow(userId, userIdToUnfollow));
    }
}
