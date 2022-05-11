package com.bootcamp.be_java_hisp_w15_g02.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@Data
public class PostCreateDTO {

    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate date;
    @Valid
    private ProductDTO detail;
    @NotEmpty(message = "El campo no puede estar vacio")
    private String category;
    @NotNull(message = "El campo no puede estar vacio")
    @Max(value = 10000000, message = "El precio maximo por producto es de 10000000") @Min(0)
    private Double price;
    private boolean has_Promo;
    private double discount;

    public PostCreateDTO() {
    }

    public PostCreateDTO(int user_id, LocalDate date, ProductDTO detail, String category, double price) {
        this.user_id = user_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public PostCreateDTO(int user_id, LocalDate date, ProductDTO detail, String category, double price, boolean has_Promo, double discount) {
        this.user_id = user_id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.has_Promo = has_Promo;
        this.discount = discount;
    }
}
