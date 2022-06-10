package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(Category category);

    Product findProductById(Long productId);

    List<Product> findAll();

    public default Product getProduct(Long idProduct) {
        return this.findAll().stream()
                .filter(x -> x.getId() == idProduct)
                .findFirst().orElseThrow(() -> new ProductNotFoundException(idProduct));
    }
}
