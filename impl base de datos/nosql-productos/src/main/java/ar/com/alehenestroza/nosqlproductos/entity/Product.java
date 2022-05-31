package ar.com.alehenestroza.nosqlproductos.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private ProductType type;
    private Double price;
    private Double cost;
    private Integer quantity;
}
