package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;

public class ProductFactory {

    public static Product create() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("Product 1");
        product.setBrand("Brand 1");
        product.setColor("Color 1");
        product.setNotes("Notes 1");
        product.setType("Type 1");

        return product;
    }
}
