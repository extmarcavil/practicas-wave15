package com.company.entity;

import java.util.List;

public class Locator {
    private Integer id;
    private Client client;
    private List<Booking> bookings;
    private Integer total;

    public Locator(Integer id, Client client, List<Booking> bookings) {
        this.id = id;
        this.client = client;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Locator{" +
                "id=" + id +
                ", client=" + client +
                ", bookings=" + bookings +
                ", total=" + total +
                '}';
    }
}
