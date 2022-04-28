package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.model.Post;
import com.bootcamp.be_java_hisp_w15_g02.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostPromoBySellerDTO {
    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public PostPromoBySellerDTO() {
    }

    public PostPromoBySellerDTO(Post post) {
        this.postId = post.getPostId();
        this.date = post.getDate();
        this.category = post.getCategory();
        this.detail = post.getDetail();
        this.price = post.getPrice();
        this.hasPromo = post.isHasPromo();
        this.discount = post.getDiscount();
    }
}
