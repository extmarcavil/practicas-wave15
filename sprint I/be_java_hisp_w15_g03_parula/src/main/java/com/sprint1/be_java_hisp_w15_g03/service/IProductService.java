package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPPromoListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPromoCountDTO;

public interface IProductService {
    void savePublication(PublicationDTO publication);
    SellerPListDTO getLastPublication(int userId, String order);
    void savePromoPublication(PublicationPromoDTO publication);
    SellerPromoCountDTO getPromoCount(Integer sellerId);
    SellerPPromoListDTO getPromoList(Integer sellerId);

}
