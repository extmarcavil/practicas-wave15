package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Class added in individual work. Representation of a list of discounted products with seller's id and username
 */
@Getter @Setter
public class DiscountedProductsListDTO {

    private int userId;
    private String userName;
    private List<PostDTO> posts;

    public DiscountedProductsListDTO() {
    }

    public DiscountedProductsListDTO(int userId, String userName, List<PostDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }
}
