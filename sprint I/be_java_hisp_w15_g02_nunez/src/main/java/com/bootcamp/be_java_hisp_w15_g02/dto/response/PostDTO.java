package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Class added in individual work. Response representation of data of a post
 */
@Getter @Setter
public class PostDTO {

    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public PostDTO() {
    }

    public PostDTO(int postId, LocalDate date, Product detail, int category, double price, boolean hasPromo, double discount) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
