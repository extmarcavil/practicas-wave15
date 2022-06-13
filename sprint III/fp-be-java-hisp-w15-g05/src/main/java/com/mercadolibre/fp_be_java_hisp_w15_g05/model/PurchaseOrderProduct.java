package com.mercadolibre.fp_be_java_hisp_w15_g05.model;
import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Getter @Setter
public class PurchaseOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseOrderProdNumber;

    @ManyToOne
            (
            cascade = {
                    CascadeType.MERGE
            })
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private PurchaseOrder purchaseOrderById;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product productById;

    private Integer productQuantity;
}
