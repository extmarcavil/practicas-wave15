package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionType;
import lombok.*;

/**
 * DTO de los productos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer product_id;
    private String name;
    private SectionType type;
}
