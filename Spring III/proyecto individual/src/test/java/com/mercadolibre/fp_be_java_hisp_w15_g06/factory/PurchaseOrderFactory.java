package com.mercadolibre.fp_be_java_hisp_w15_g06.factory;

import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.OrderStatus;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.PurchaseOrder;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.emptyList;

public class PurchaseOrderFactory {

    public static PurchaseOrder purchaseOrder() {
        return new PurchaseOrder(1L, LocalDate.now(), OrderStatus.SHOPPING_CART, 1500D, List.of(ProductFactory.productMilkCart()));
    }

    public static PurchaseOrder otherPurchaseOrder() {
        return new PurchaseOrder(2L, LocalDate.now(), OrderStatus.SHOPPING_CART, 1500D, List.of(ProductFactory.productMeatCart()));
    }

    public static PurchaseOrder purchaseOrderWithoutProducts() {
        return new PurchaseOrder(2L, LocalDate.now(), OrderStatus.SHOPPING_CART,1500D, emptyList());
    }
}
