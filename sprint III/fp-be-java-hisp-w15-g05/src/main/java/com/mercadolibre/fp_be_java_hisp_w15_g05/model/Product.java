package com.mercadolibre.fp_be_java_hisp_w15_g05.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer product_id;
    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinColumn(name = "section_type_id")
    SectionType type;
    private String name;

    private double price;


    @OneToMany(
            cascade = {
                    CascadeType.MERGE },
            mappedBy = "product")
    private List<Batch> batchList;

    @OneToMany(mappedBy = "productById")
    private List<PurchaseOrderProduct> purchaseOrderProductByNumber;
}
