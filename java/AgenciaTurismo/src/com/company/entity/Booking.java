package com.company.entity;

public class Booking {
    private Integer id;
    private BookingType type;
    private Float price;
    private Float discount;


    public Booking() {
    }

    public Booking(Integer id, BookingType type, Float price, Float discount) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookingType getBookingType() {
        return this.type;
    }

    public void setBookingType(BookingType type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
