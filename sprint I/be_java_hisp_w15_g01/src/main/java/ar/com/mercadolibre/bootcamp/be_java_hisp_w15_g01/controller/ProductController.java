package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;
import java.util.List;

@Log
@RestController
@RequestMapping("/products")
public class ProductController {

    private PostService service;

    public ProductController(PostService service) {
        this.service = service;
    }

    /**
     * ProductController
     * Crea una publicacion
     *
     * @param postDTO el dto de la publicacion a crear
     */
    @PostMapping({"/post", "/promo-post"})
    public ResponseEntity<ResponseDTO> create(@RequestBody PostDTO postDTO) {
        log.info("Se recibio peticion de creacion de una publicacion");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.createPost(postDTO));
    }

    /**
     * ProductController
     * Devuelve la lista de usuarios que siguen al parametro userId
     *
     * @param userId User a buscar.
     * @param order orden de los resultados.
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getFollowList(@PathVariable Long userId, @RequestParam(required = false) String order) {
        log.info("Se recibio peticion de obtener todos los posts de las personas que sigue el id " + userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostsByFollowedUsers(userId, order));
    }

    /**
     * ProductController
     * Obtener la cantidad de publicaciones con promocion de un usuario
     *
     * @param user_id Id de usuario
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<VendorInfoDTO> getPromoPostCount(@RequestParam(required = true) Long user_id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPostCount(user_id, true, null));
    }

    /**
     * ProductController
     * Obtener la lista de publicaciones con promoción de un usuario
     *
     * @param user_id Id de usuario
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<PostListDTO> getPromoPosts(@RequestParam(required = true) Long user_id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPromoPostsByUser(user_id));
    }

    /**
     * ProductController
     * Obtener una lista de vendedores con mas publicaciones en cierto intervalo, ordenado de manera descendente
     *
     * @param days_interval Intervalo en días
     */
    @GetMapping("/posters/ranking")
    public ResponseEntity<List<VendorInfoDTO>> getPosterRanking(@RequestParam(required = false) Integer days_interval) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getPosterRanking(days_interval));
    }


}
