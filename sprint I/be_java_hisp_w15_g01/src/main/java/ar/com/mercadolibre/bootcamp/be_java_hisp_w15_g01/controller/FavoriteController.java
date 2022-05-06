package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FavoriteDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FavoritesCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    private FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> add(@Valid @RequestBody FavoriteDTO favoriteDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(favoriteService.create(favoriteDTO));
    }
    
    @GetMapping("/{userId}/count")
    public ResponseEntity<FavoritesCountDTO> getFavorites(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(favoriteService.getFavorites(userId));
    }


    }
