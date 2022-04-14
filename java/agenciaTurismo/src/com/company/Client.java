package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {

    private String name;
    private String lastName;
    private String dni;
    private double discount;
    private HashMap<BOOKING, Integer> bookings = new HashMap<>();
    private ArrayList<HashMap> localizators = new ArrayList<>();


    //calculate de discount that the company will give to the client
    public void discountCalculator() {
        int counter = 0;

        if(localizators.size() >= 1){
            this.discount = 0.5;
        }

        for(BOOKING book: bookings.keySet()){
            if(book == BOOKING.FOOD || book == BOOKING.TRANSPORT || book == BOOKING.TRAVEL_TIQUET || book == BOOKING.HOTEL_BOOKING){
                counter += 1;
                return;
            }
        }
        if(counter == 5){
            discount = 0.10;
            return;
        }

        if(bookings.get(BOOKING.HOTEL_BOOKING) == 2 || bookings.get(BOOKING.TRAVEL_TIQUET) == 2){
            discount = 0.5;
            return;
        }

    }

    public Client(String name, String lastName, String dni) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public HashMap<BOOKING, Integer> getBookings() {
        return bookings;
    }

    public void setBookings(BOOKING booking, int cantidad) {
        bookings.put(booking, cantidad);
        localizators.add(this.bookings);
    }

    public ArrayList<HashMap> getLocalizators() {
        return localizators;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", discount=" + discount +
                ", bookings=" + bookings +
                ", localizators=" + localizators +
                '}';
    }
}
