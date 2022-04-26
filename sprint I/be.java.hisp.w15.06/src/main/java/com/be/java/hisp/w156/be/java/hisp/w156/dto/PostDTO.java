package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import com.be.java.hisp.w156.be.java.hisp.w156.adapter.JsonAdapter;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
public class PostDTO implements Serializable {

    @NotNull
    private Integer userId;
    //@JsonDeserialize(using = JsonAdapter.class)
    //@JsonFormat(pattern="dd-MM-yyyy", timezone="America/Buenos_Aires")
    @NotNull
    private String date;
    private Product detail;
    private String category;
    private Double price;

}
