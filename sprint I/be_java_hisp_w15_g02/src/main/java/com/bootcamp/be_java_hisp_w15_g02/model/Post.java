package com.bootcamp.be_java_hisp_w15_g02.model;

import java.time.LocalDate;

public class Post {
    private int user_id;
    private LocalDate date;
    private int category;
    private Product detail;
    private double price;
    private boolean has_promo;
    private double discount;

    public Post() {
    }

    public Post(int user_id, LocalDate date, int category, Product detail, double price, boolean has_promo, double discount) {
        this.user_id = user_id;
        this.date = date;
        this.category = category;
        this.detail = detail;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public Post(int user_id, LocalDate date, int category, Product detail, double price) {
        this.user_id = user_id;
        this.date = date;
        this.category = category;
        this.detail = detail;
        this.price = price;
        this.has_promo = false;
        this.discount = 0.0;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public boolean isHas_promo() {
        return has_promo;
    }

    public void setHas_promo(boolean has_promo) {
        this.has_promo = has_promo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
