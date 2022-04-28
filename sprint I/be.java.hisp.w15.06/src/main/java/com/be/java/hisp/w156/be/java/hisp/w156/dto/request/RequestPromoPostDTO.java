package com.be.java.hisp.w156.be.java.hisp.w156.dto.request;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPromoPostDTO implements Serializable {

        private int id_usuario;
        @JsonFormat(pattern = "dd-MM-yyyy")
        private LocalDate date;
        private Product detail; //Esto seria una lista?
        private String category;
        private Double price;
        private boolean has_promo; // Como manejar el has_promo??
        private double discount;



    }



