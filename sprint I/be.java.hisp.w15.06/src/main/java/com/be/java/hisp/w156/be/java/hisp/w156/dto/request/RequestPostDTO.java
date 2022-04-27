package com.be.java.hisp.w156.be.java.hisp.w156.dto.request;

import com.be.java.hisp.w156.be.java.hisp.w156.adapter.JsonAdapterDeserializer;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class RequestPostDTO {

    @NotNull
    private Integer userId;

    @JsonDeserialize(using = JsonAdapterDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone="America/Buenos_Aires")
    private String date;

    private Product detail;
    private String category;
    private Double price;

}
