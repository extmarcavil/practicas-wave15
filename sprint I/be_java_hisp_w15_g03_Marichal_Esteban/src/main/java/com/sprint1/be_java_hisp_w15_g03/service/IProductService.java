package com.sprint1.be_java_hisp_w15_g03.service;

import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.PublicationWithPromoDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PublicationPCountDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.PublicationPListDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.SellerPListDTO;

public interface IProductService {
    void savePublication(PublicationDTO publication);
    SellerPListDTO getLastPublication(int userId, String order);
    void savePublicationWithPromo(PublicationWithPromoDTO publication);
    PublicationPCountDTO getPublicationsWithPromo(Integer sellerId);
    PublicationPListDTO getPublicationsWithPromoList(Integer sellerId);
}
