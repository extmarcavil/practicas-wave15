package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.UserDto;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable Long userId, @PathVariable long userIdToFollow) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.follow(userId, userIdToFollow));
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDto> AllFollowedByUserId(@PathVariable Long userId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllFollowedByUserId(userId));

    }
}
