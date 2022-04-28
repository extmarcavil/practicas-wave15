package com.sprint1.be_java_hisp_w15_g03.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Publication {

    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Category category;
    private Double price;
    private Product detail;
    private Boolean hasPromo;
    private Double discount;

    public Publication() {
    }

    public Publication(Integer postId, LocalDate date, Category category, Double price, Product detail) {
        this.postId = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.detail = detail;
        this.hasPromo = false;
        this.discount = 0d;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "postId=" + postId +
                ", date=" + date +
                ", category=" + category +
                ", price=" + price +
                ", detail=" + detail +
                ", hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }
}
