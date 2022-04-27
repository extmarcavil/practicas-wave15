package com.be.java.hisp.w156.be.java.hisp.w156.dto.request;

import com.be.java.hisp.w156.be.java.hisp.w156.adapter.JsonAdapterDeserializer;
import com.be.java.hisp.w156.be.java.hisp.w156.adapter.JsonAdapterSerializer;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class RequestPostDTO {

    @NotNull
    private Integer user_id;

    @JsonSerialize(using = JsonAdapterSerializer.class)
    @JsonDeserialize(using = JsonAdapterDeserializer.class)
    private LocalDate date;

    private Product detail;
    private String category;
    private Double price;

}
