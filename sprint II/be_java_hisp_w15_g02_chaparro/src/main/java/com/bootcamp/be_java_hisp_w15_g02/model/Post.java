package com.bootcamp.be_java_hisp_w15_g02.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Post {
    private int postId;
    private int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull private LocalDate date;
    private int category;
    private Product detail;
    private Double price;
    private boolean hasPromo;
    private double discount;

    public Post() {
    }

    public Post(int postId, int userId, LocalDate date, int category, Product detail, double price, boolean hasPromo, double discount) {
        this.userId = userId;
        this.date = date;
        this.category = category;
        this.detail = detail;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
        this.postId = postId;
    }

    public Post(int postId,int userId, LocalDate date, int category, Product detail, double price) {
        this.userId = userId;
        this.date = date;
        this.category = category;
        this.detail = detail;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
