package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;


import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;

public class ProductCategoryIsDifferentFromSectionCategoryException extends RuntimeException {
    public ProductCategoryIsDifferentFromSectionCategoryException(Product product, Section section) {
        super("La categoría " + product.getCategory() + " del producto con id " + product.getId() +
                " no debe ser distinta de la categoría " + section.getCategory() + " del sector con id " + section.getId());
    }
}
