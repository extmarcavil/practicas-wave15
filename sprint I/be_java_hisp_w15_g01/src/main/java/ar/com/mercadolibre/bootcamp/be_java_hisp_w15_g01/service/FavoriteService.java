package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FavoriteDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FavoritesCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;

public interface FavoriteService {
    ResponseDTO create(FavoriteDTO favoriteDTO);

    FavoritesCountDTO getFavorites(Long userId);
}