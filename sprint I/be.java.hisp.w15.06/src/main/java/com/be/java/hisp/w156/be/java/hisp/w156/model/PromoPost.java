package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PromoPost {

    private int id_usuario;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product detail; //Esto seria una lista?
    private String category;
    private Double price;
    private boolean has_promo; // Como manejar el has_promo??
    private double discount;

}
