package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "type", "brand", "color", "notes" })
public class Product {

    @JsonProperty("product_id")
    private Integer id;

    @JsonProperty("product_name")
    private String name;

    private String type;
    private String brand;
    private String color;
    private String notes;

}
