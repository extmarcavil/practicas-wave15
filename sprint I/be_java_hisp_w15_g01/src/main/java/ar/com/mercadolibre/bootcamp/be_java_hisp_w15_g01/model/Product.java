package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
