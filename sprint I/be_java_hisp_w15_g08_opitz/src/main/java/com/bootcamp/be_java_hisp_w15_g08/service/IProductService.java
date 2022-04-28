package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.request.PromoProductDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PromoProductsCountDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PromoProductsListDTO;

public interface IProductService {
    void addPromoProduct(PromoProductDTO product);
    PromoProductsCountDTO getPromoProductsCount(Integer userId);
    PromoProductsListDTO getSellersProducts(Integer userId);
}
