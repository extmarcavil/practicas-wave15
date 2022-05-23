package com.meli.elasticsearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.elasticsearch.domain.Clothe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.UUID;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClotheDto implements ElasticDocumentDto {

    @Nullable
    private final String id;
    @Nullable
    private final UUID code;
    @Nullable
    private final String name;
    @Nullable
    private final String type;
    @Nullable
    private final String color;
    @Nullable
    private final String size;
    @Nullable
    private final Integer quantity;
    @Nullable
    private Double salePrice;   // better BigDecimal for price

    public static ClotheDto from(Clothe clothe) {
        return new ClotheDto(
                clothe.getId(),
                clothe.getCode(),
                clothe.getName(),
                clothe.getType(),
                clothe.getColor(),
                clothe.getSize(),
                clothe.getQuantity(),
                clothe.getSalePrice()
        );
    }

}
