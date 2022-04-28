package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowedListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;
import lombok.extern.java.Log;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Log
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * UserController
     * Accion de seguir a un vendedor
     *
     * @param userId El usuario que quiere seguir a otro usuario
     * @param userIdToFollow El usuario target al cual quieren seguir
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable Long userId, @PathVariable long userIdToFollow) {
        log.info("following userId: " + userId + " to userId: " + userIdToFollow);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.follow(userId, userIdToFollow));
    }

    /**
     * UserController
     * Devuelve la cuenta de cuantas personas siguen a userId
     *
     * @param userId El usuario a buscar
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> howManyFollowsMe(@PathVariable Long userId) {
        log.info("how many follows userId: " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.howManyFollowsMe(userId));
    }

    /**
     * UserController
     * Devuelve la lista de quienes siguen a userId
     *
     * @param userId El usuario a buscar
     * @param order El orden de los parametros
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> whoFollowsMe(@PathVariable Long userId, @RequestParam(required=false) String order) {
        log.info("who follows userId: " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.whoFollowsMe(userId, order));

    }

    /**
     * UserController
     * Devuelve la la lista de todas las personas a las que sigue userId
     *
     * @param userId El usuario a buscar
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> AllFollowedByUserId(@PathVariable Long userId , @RequestParam(required = false) String order){
        log.info("All Post by users followed by userId: " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllFollowedByUserId(userId, order));
    }

    /**
     * UserController
     * Accion de dejar de seguir a un vendedor
     *
     * @param userId El usuario que quiere dejar de seguir a otro usuario
     * @param userIdToUnfollow El usuario target al cual quieren dejar de seguir
     */
    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> unFollow(@PathVariable long userId, @PathVariable long userIdToUnfollow){
        log.info("unfollowing userId: " + userId + " to userId: " + userIdToUnfollow);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.unFollow(userId, userIdToUnfollow));
    }
}
