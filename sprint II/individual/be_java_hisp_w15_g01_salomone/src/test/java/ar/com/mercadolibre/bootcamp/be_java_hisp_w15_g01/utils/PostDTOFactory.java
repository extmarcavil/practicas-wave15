package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ProductDTO;

public class PostDTOFactory {
    public static PostDTO createPost() {
        ProductDTO detail = new ProductDTO();
        detail.setBrand("bmw");
        detail.setColor("black");
        detail.setNotes("rumm rummm");
        detail.setProductId(25L);
        detail.setType("car");
        detail.setProductName("bmw z4");
        PostDTO dto = new PostDTO();
        dto.setCategory(100);
        dto.setPostId(10L);
        dto.setUserId(1L);
        dto.setDate("05-05-2022");
        dto.setPrice(10000F);
        dto.setDetail(detail);
        return dto;
    }
}
