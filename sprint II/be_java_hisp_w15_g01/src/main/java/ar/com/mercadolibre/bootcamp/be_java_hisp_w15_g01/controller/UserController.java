package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowedListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.FollowRequestDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.request.WhoAndHowManyFollowsMeRequestDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.UserService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

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
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> follow(@Valid FollowRequestDTO dto) {
        Long userId = dto.getUserId();
        Long userIdToFollow = dto.getUserIdToFollow();
        log.info("Se recibe peticion de seguir, id " + userId + " a id " + userIdToFollow);
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
    public ResponseEntity<FollowersCountDTO> wowManyFollowsMe(
            @PathVariable @Min(value = 1, message = "El id debe ser mayor a cero") Long userId
    ) {
        log.info("Se recibe peticion de cantidad de seguidores del id " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.wowManyFollowsMe(userId));
    }

    /**
     * UserController
     * Devuelve la lista de quienes siguen a userId
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> whoFollowsMe(@Valid WhoAndHowManyFollowsMeRequestDTO dto) {
        Long userId = dto.getUserId();
        String order = dto.getOrder();
        log.info("Se recibe peticion de lista de seguidores del id " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.whoFollowsMe(userId, order));

    }


    /**
     * UserController
     * Devuelve la la lista de todas las personas a las que sigue userId
     *
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> AllFollowedByUserId(@Valid WhoAndHowManyFollowsMeRequestDTO dto){
        Long userId = dto.getUserId();
        String order = dto.getOrder();
        log.info("Se recibe peticion de lista de seguidos del id " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllFollowedByUserId(userId, order));
    }

    /**
     * UserController
     * Accion de dejar de seguir a un vendedor
     *
     */
    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> unFollow(@Valid FollowRequestDTO dto){
        Long userId = dto.getUserId();
        Long userIdToUnfollow = dto.getUserIdToFollow();
        log.info("Se recibe peticion de dejar de seguir, id " + userId + " a id " + userIdToUnfollow);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.unFollow(userId, userIdToUnfollow));
    }

}
