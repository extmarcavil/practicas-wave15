package com.social.media.sprgbt.repository.impl;

import com.social.media.sprgbt.entity.Product;
import com.social.media.sprgbt.entity.User;
import com.social.media.sprgbt.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Repository
public class ProductoRepositoryImpl implements IProductRepository {

    private static final AtomicInteger count = new AtomicInteger(0);

    /**
     * Lista de Productos
     */
    private List<Product> listProducts;

    /**
     * Constructor por Default
     */
    public ProductoRepositoryImpl() {
        this.listProducts = new ArrayList<>();
    }

    /**
     * Create Products
     *
     * @param product
     * @return {@link Product} obj
     */
    @Override
    public Product createProduct(Product product) {
        product.setProductId(count.incrementAndGet());
        log.info("Product: {}", product);

        listProducts.add(product);

        return product;
    }

    /**
     * Get All Products
     *
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        return listProducts;
    }

    /**
     * Get Producto By id
     *
     * @param id
     * @return {@link Product} obj
     */
    public Product getProductById(Integer id) {
        Optional<Product> productOpt = listProducts.stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst();

        return productOpt.orElse(null);
    }

    /**
     * Get Producto By nameProduct
     *
     * @param productName param
     * @return {@link Product} obj
     */
    @Override
    public Product getProductByName(String productName) {
        Optional<Product> product = listProducts.stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                .findFirst();

        return product.orElse(null);
    }
}
