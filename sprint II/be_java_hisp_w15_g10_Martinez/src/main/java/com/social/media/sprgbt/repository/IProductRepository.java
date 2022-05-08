package com.social.media.sprgbt.repository;


import com.social.media.sprgbt.entity.Product;

import java.util.List;

public interface IProductRepository {


    /**
     * Create Products
     *
     * @param product
     * @return {@link Product} obj
     */
    Product createProduct(Product product);

    /**
     * Get All Products
     *
     * @return
     */
    List<Product> getAllProducts();

    /**
     * Get Producto By id
     *
     * @param id
     * @return {@link Product} obj
     */
    Product getProductById(Integer id);

    /**
     * Get Producto By nameProduct
     *
     * @param productName param
     * @return {@link Product} obj
     */
    Product getProductByName(String productName);

}
