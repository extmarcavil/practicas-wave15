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
     * Endpoint US 01
     * Realizar la acción de “Follow” (seguir) a un determinado vendedor
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@PathVariable Long userId, @PathVariable long userIdToFollow) {
        log.info("following userId: " + userId + " to userId: " + userIdToFollow);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.follow(userId, userIdToFollow));
    }

    /**
     * Endpoint US 02
     * Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> howManyFollowsMe(@PathVariable Long userId) {
        log.info("how many follows userId: " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.howManyFollowsMe(userId));
    }

    /**
     * Endpoint US 03 y 08
     * Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).
     * Ordenamiento alfabético ascendente y descendente
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> whoFollowsMe(@PathVariable Long userId, @RequestParam(required=false) String order) {
        log.info("who follows userId: " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.whoFollowsMe(userId, order));

    }

    /**
     * Endpoint US 04 y 08
     * Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).
     * Ordenamiento alfabético ascendente y descendente
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> AllFollowedByUserId(@PathVariable Long userId , @RequestParam(required = false) String order){
        log.info("All Post by users followed by userId: " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllFollowedByUserId(userId, order));
    }

    /**
     * Endpoint US 07
     * Realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     */
    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> unFollow(@PathVariable long userId, @PathVariable long userIdToUnfollow){
        log.info("unfollowing userId: " + userId + " to userId: " + userIdToUnfollow);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.unFollow(userId, userIdToUnfollow));
    }
}
