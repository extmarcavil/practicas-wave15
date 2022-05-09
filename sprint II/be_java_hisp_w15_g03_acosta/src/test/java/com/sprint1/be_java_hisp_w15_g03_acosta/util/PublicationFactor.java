package com.sprint1.be_java_hisp_w15_g03_acosta.util;

import com.sprint1.be_java_hisp_w15_g03_acosta.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03_acosta.dto.request.PublicationDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Carga de datos para Testing
 */

public class PublicationFactor {

    public static List<ProductDTO> product(){
        ProductDTO productDTO = new ProductDTO(1, "Silla Gamer", "Sillas", "Racer" , "Red", "Special edition");
        ProductDTO productDTO2 = new ProductDTO(2, "Mesa Gamer", "Mesa", "Racer" , "Red", "Special edition");

        List<ProductDTO> products = new ArrayList<>();
        products.add(productDTO);
        products.add(productDTO2);
        return products;
    }

    public static List<PublicationDTO> publication(){
        PublicationDTO publicationDTO = new PublicationDTO(3, LocalDate.now(),product().get(0), 2, 3000.00 );
        PublicationDTO publicationDTO2 = new PublicationDTO(4, LocalDate.now(),product().get(1), 2, 4000.00 );
        PublicationDTO publicationDTO3 = new PublicationDTO(100, LocalDate.now(), product().get(1), 2, 3000.00);

        List<PublicationDTO> publications = new ArrayList<>();
        publications.add(publicationDTO);
        publications.add(publicationDTO2);
        publications.add(publicationDTO3);
        return publications;
    }



}
