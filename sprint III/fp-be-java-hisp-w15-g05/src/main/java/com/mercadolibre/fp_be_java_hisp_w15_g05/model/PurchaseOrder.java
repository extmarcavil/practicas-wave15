package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    private LocalDate date;
    private String order_status;
    private Integer buyer_id;

    @OneToMany(
            fetch = FetchType.EAGER,
             mappedBy = "purchaseOrderById")
    private List<PurchaseOrderProduct> purchaseOrderProductByNumber;
}
