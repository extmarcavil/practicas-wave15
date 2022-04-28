package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDiscountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PromotionCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PublicationDiscountListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;

public interface IProductService {
    void savePublication(PublicationDTO publication);
    void savePublicationWithPromotion(PublicationDiscountDTO publicationPromotionDTO);
    SellerPListDTO getLastPublication(int userId, String order);
    PromotionCountDTO getCantProductsWithDiscount(Integer sellerId);PublicationDiscountListDTO getListPublicationWithDiscount(Integer userId);


}
