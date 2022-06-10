package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos;

import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.ProductCart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductDTO {

    private Long id;
    private String name;

    public static ProductDTO from(Product product) {
        return new ProductDTO(product.getId(), product.getName());
    }

    public static ProductDTO fromCart(ProductCart product) {
        return new ProductDTO(product.getId(), product.getName());
    }
}
