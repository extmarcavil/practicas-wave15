package sprint1.socialmeli.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import sprint1.socialmeli.dto.ResponseFollowedListDTO;
import sprint1.socialmeli.dto.ResponseFollowersCountDTO;
import sprint1.socialmeli.dto.ResponseFollowersListDTO;
import sprint1.socialmeli.service.ISocialMeliService;

@RestController
public class SocialMeliController {

    ISocialMeliService service;

    public SocialMeliController(ISocialMeliService service) {
        this.service = service;
    }

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    //POST users/{userId}/follow/{userIdToFollow}
    //Ejemplo: /users/1235/follow/1569
    //Response
    //Status Code 200 (todo OK)
    //Status Code 400 (Bad Request)
    @PostMapping("/users/{userID}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userID, @PathVariable int userIdToFollow){
        service.follow(userID,userIdToFollow);
        return new ResponseEntity<>("El usuario: "+ userID + " comenzo a seguir a "+ userIdToFollow ,HttpStatus.OK);
    }


    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    //GET users/{userId}/followers/count
    //Ejemplo: /users/1569/followers/count/
    //Response
    //{
    //    "user_id": 1569,
    //    "user_name": "vendedor1",
    //    "followers_count": 35
    //}
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<ResponseFollowersCountDTO> countFollowers(@PathVariable Integer userId){
        return new ResponseEntity<>(service.countFollowers(userId), HttpStatus.OK);
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    //GET users/{userId}/followers/list
    //Ejemplo: /users/1569/followers/list
    //Response
    //{
    //    "user_id": 1569,
    //    "user_name": "vendedor1",
    //    "followers": [
    //        {
    //            "user_id": 4698,
    //            "user_name": "usuario1"
    //        },
    //        {
    //            "user_id": 1536,
    //            "user_name": "usuario2"
    //        },
    //        {
    //            "user_id": 2236,
    //            "user_name": "usuario3"
    //        }
    //    ]
    //}

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<ResponseFollowersListDTO> listFollowers(@PathVariable Integer userId, @RequestParam @Nullable String order){
        if (order == null) {
            return new ResponseEntity<>(service.listFollowers(userId), HttpStatus.OK);
        }
        return ResponseEntity.ok(this.service.sortedListFollowers(userId, order));
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    //GET users/{userId}/followed/list
    //Ejemplo: /users/4698/followed/list
    //Response
    //{
    //    "user_id": 4698,
    //    "user_name": "usuario1",
    //    "followed": [
    //        {
    //            "user_id": 1569,
    //            "user_name": "vendedor1"
    //        },
    //        {
    //            "user_id": 6932,
    //            "user_name": "vendedor2"
    //        },
    //        {
    //            "user_id": 6631,
    //            "user_name": "vendedor3"
    //        }
    //    ]
    //}

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<ResponseFollowedListDTO> listFollowed(@PathVariable Integer userId, @RequestParam @Nullable String order){
        if (order == null) {
            return new ResponseEntity<>(service.listFollowed(userId), HttpStatus.OK);
        }
        return ResponseEntity.ok(this.service.sortedListFollowed(userId, order));
    }

    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    //POST users/{userId}/unfollow/{userIdToUnfollow}
    //Ejemplo: /users/1569/unfollow/1235

    @PostMapping("/users/{userID}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userID, @PathVariable int userIdToUnfollow){
        service.unfollow(userID,userIdToUnfollow);
        return new ResponseEntity<>("El usuario: "+ userID + " dejo de seguir a "+ userIdToUnfollow ,HttpStatus.OK);
    }

    //US 0008: Ordenamiento alfabético ascendente y descendente
    //GET
    //Ejemplos:
    ///users/{UserID}/followers/list?order=name_asc
    ///users/{UserID}/followers/list?order=name_desc
    ///users/{UserID}/followed/list?order=name_asc
    ///users/{UserID}/followed/list?order=name_desc

    //US 0009: Ordenamiento por fecha ascendente y descendente
    //GET
    //Ejemplos:
    ///products/followed/{userId}/list?order=date_asc
    ///products/followed/{userId}/list?order=date_desc


}
