package com.bootcamp.be_java_hisp_w15_g02_sanchez.dto.response;

import com.bootcamp.be_java_hisp_w15_g02_sanchez.model.Post;
import com.bootcamp.be_java_hisp_w15_g02_sanchez.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostsBySellersDTO {
    private int postId;
    private int userId;
    private LocalDate date;
    private int category;
    private Product detail;
    private double price;

    public PostsBySellersDTO(Post post) {
        this.postId = post.getPostId();
        this.userId = post.getUserId();
        this.date = post.getDate();
        this.category = post.getCategory();
        this.detail = post.getDetail();
        this.price = post.getPrice();
    }

    public PostsBySellersDTO() {
    }
}
