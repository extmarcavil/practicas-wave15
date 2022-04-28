package com.company.repository;

import com.company.entity.Booking;
import com.company.entity.Client;

import java.util.List;
import java.util.Map;

public class BookingRepository {
    private Map<Integer, Booking> bookings;

    public BookingRepository() {

    }

    public BookingRepository(Map<Integer, Booking> bookings) {
        this.bookings = bookings;
    }

    public Map<Integer, Booking> getBookings() {
        return this.bookings;
    }

    public Integer getCountBookings() {
        return this.bookings.size();
    }

    public void addBooking(Booking booking) {
        this.bookings.put(booking.getId(), booking);
    }

    public Booking getBooking(Integer id) {
        return this.bookings.get(id);
    }

}
