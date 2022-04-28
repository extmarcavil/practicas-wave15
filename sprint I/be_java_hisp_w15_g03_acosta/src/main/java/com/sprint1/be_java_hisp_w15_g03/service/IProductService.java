package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerCountPPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPPromoListDTO;

public interface IProductService {
    void savePublication(PublicationDTO publication);
    SellerPListDTO getLastPublication(int userId, String order);

    void savePublicationPromo(PublicationPromoDTO publication);

    SellerCountPPromoDTO ProductsPromoCount(Integer userId);

    SellerPPromoListDTO getPublicationsPPromoList(Integer userId);
}
