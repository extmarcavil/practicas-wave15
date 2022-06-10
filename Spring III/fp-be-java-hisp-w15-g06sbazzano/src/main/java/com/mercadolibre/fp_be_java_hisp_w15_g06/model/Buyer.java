package com.mercadolibre.fp_be_java_hisp_w15_g06.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "buyer_id")
    private List<PurchaseOrder> purchaseOrders;
}
