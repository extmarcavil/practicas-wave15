package sprint2.socialmeli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sprint2.socialmeli.dto.user.ResponseFollowedListDTO;
import sprint2.socialmeli.dto.user.ResponseFollowersCountDTO;
import sprint2.socialmeli.dto.user.ResponseFollowersListDTO;
import sprint2.socialmeli.service.ISocialMeliService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
@RestController
public class SocialMeliController {
    ISocialMeliService service;

    public SocialMeliController(ISocialMeliService service) {
        this.service = service;
    }

    // US 0001
    @PostMapping("/users/{userID}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") Integer userID,
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") Integer userIdToFollow){
        service.follow(userID,userIdToFollow);
        return ResponseEntity.ok("El usuario: "+ userID + " comenzo a seguir a "+ userIdToFollow);
    }

    // US 0002
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<ResponseFollowersCountDTO> countFollowers(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") Integer userId){
        return ResponseEntity.ok(service.countFollowers(userId));
    }

    //US 0003 - US 0008
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<ResponseFollowersListDTO> listFollowers(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") Integer userId, @RequestParam @Nullable String order){
        return ResponseEntity.ok(service.listFollowers(userId, order));
    }

    //US 0004 - US 0008
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<ResponseFollowedListDTO> listFollowed(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") Integer userId, @RequestParam @Nullable String order){
        return ResponseEntity.ok(service.listFollowed(userId, order));
    }

    //US 0007
    @PostMapping("/users/{userID}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") Integer userID,
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") Integer userIdToUnfollow){
        service.unfollow(userID,userIdToUnfollow);
        return ResponseEntity.ok("El usuario: "+ userID + " dejo de seguir a "+ userIdToUnfollow);
    }
}
