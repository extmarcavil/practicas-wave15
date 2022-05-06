package com.sprint1.be_java_hisp_w15_g03_acosta.service;

import com.sprint1.be_java_hisp_w15_g03_acosta.dto.request.PublicationDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.response.SellerPListDTO;

public interface IProductService {
    void savePublication(PublicationDTO publication);
    SellerPListDTO getLastPublication(int userId, String order);
}
