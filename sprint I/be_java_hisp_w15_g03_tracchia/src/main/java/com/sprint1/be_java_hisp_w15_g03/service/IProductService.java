package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PromoCountDT0;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PromoListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;

public interface IProductService {

    void savePublicationWithoutPromo(PublicationDTO publication);
    void savePromoPublication(PublicationPromoDTO promo);
    SellerPListDTO getLastPublication(int userId, String order);
    PromoCountDT0 getPromoCount(int userId);
    PromoListDTO getPromoList(int userId);
}
