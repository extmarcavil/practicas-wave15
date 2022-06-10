package com.mercadolibre.fp_be_java_hisp_w15_g06.factory;

import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.ProductCart;

public class ProductFactory {

    public static Product milk() {
        return new Product(1L, "Milk", Category.RF, 15.0);
    }

    public static Product meat() {
        return new Product(2L, "Meat", Category.FF, 10.0);
    }

    public static ProductCart productMilkCart() {
        return new ProductCart(1L, "Milk", Category.RF, 15.0, 5);
    }
    public static ProductCart productMeatCart() {
        return new ProductCart(1L, "Milk", Category.RF, 15.0, 5);
    }

}
