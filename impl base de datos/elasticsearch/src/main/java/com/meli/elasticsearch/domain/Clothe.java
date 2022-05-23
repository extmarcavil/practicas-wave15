package com.meli.elasticsearch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.elasticsearch.dto.ClotheDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Document(indexName = "clothe")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Clothe implements ElasticDocument {

    public static final String INDEX = "clothe";

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private UUID code;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String type;

    @Field(type = FieldType.Text)
    private String color;

    @Field(type = FieldType.Text)
    private String size;

    @Field(type = FieldType.Integer)
    private Integer quantity;

    @JsonProperty("sale_price")
    @Field(name = "sale_price", type = FieldType.Double)
    private Double salePrice;

    public static Clothe forSave(ClotheDto clotheDto) {
        return new Clothe(
                null,
                UUID.randomUUID(),
                clotheDto.getName(),
                clotheDto.getType(),
                clotheDto.getColor(),
                clotheDto.getSize(),
                clotheDto.getQuantity(),
                clotheDto.getSalePrice()
        );
    }
}
