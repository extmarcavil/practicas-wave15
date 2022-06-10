package com.mercadolibre.fp_be_java_hisp_w15_g06.model;

import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "purchase_orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Double totalPrice;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_card_id")
    private List<ProductCart> productCars;

    public PurchaseOrder(LocalDate date, OrderStatus orderStatus, Double totalPrice, List<ProductCart> productCars) {
        this.date = date;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.productCars = productCars;
    }

    public static PurchaseOrder createOrderFrom(LocalDate purchaseDate, List<ProductCart> productsForOrder) {
        return new PurchaseOrder(
                purchaseDate,
                OrderStatus.SHOPPING_CART,
                calculatePrice(productsForOrder),
                productsForOrder
        );
    }

    private static Double calculatePrice(List<ProductCart> productsForOrder) {
        return productsForOrder.stream()
                .mapToDouble(ProductCart::getPrice)
                .sum();
    }
}
