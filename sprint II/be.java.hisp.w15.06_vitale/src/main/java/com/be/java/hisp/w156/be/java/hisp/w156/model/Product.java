package com.be.java.hisp.w156.be.java.hisp.w156.model;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.ProductDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Product {

    private Integer product_id;

    private String product_name;

    private String type;

    private String brand;

    private String color;

    private String notes;

    public static Product from(ProductDTO detail) {
        return new Product(detail.getProduct_id(), detail.getProduct_name(), detail.getType(),
                detail.getBrand(), detail.getColor(), detail.getNotes());
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
