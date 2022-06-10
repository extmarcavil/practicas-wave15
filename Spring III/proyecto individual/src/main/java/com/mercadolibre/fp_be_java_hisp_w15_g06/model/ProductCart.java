package com.mercadolibre.fp_be_java_hisp_w15_g06.model;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.RequestProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products_cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Double price;

    private Integer quantity;


    public static ProductCart from(Product product, List<RequestProductDTO> products) {
        return new ProductCart(
                null,
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                calculateQuantity(product, products)
        );
    }

    private static Integer calculateQuantity(Product product, List<RequestProductDTO> products) {
        return products.stream().filter(p -> p.getProductId().equals(product.getId()))
                .findFirst()
                .map(RequestProductDTO::getQuantity)
                .orElse(0);
    }
}
