package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FavoriteDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostPromoCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostPromoDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;

import java.time.LocalDate;

public interface FavoriteService {
    ResponseDTO create(FavoriteDTO favoriteDTO);
}