package sprint1.socialmeli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import sprint1.socialmeli.dtos.FollowedListDTO;
import sprint1.socialmeli.dtos.FollowersCountDTO;
import sprint1.socialmeli.dtos.FollowersListDTO;
import sprint1.socialmeli.service.ISocialMeliService;

@RestController
public class    SocialMeliController {
    ISocialMeliService service;

    public SocialMeliController(ISocialMeliService service) {
        this.service = service;
    }

    // US 0001
    @PostMapping("/users/{userID}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userID, @PathVariable int userIdToFollow){
        service.follow(userID,userIdToFollow);
        return ResponseEntity.ok("El usuario: "+ userID + " comenzo a seguir a "+ userIdToFollow);
    }

    // US 0002
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> countFollowers(@PathVariable Integer userId){
        return ResponseEntity.ok(service.countFollowers(userId));
    }

    //US 0003 - US 0008
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> listFollowers(@PathVariable Integer userId, @RequestParam @Nullable String order){
        return ResponseEntity.ok(service.listFollowers(userId, order));
    }

    //US 0004 - US 0008
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> listFollowed(@PathVariable Integer userId, @RequestParam @Nullable String order){
        return ResponseEntity.ok(service.listFollowed(userId, order));
    }

    //US 0007
    @PostMapping("/users/{userID}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userID, @PathVariable int userIdToUnfollow){
        service.unfollow(userID,userIdToUnfollow);
        return ResponseEntity.ok("El usuario: "+ userID + " dejo de seguir a "+ userIdToUnfollow);
    }
}
