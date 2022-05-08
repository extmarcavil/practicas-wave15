package com.social.media.sprgbt.unit.repository;


import com.social.media.sprgbt.entity.Product;

import com.social.media.sprgbt.repository.IProductRepository;
import com.social.media.sprgbt.repository.impl.ProductoRepositoryImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ProductoRepositoryImplTest {


    /**
     * Instancia de la clase a testear CategoryRepositoryImpl
     */
    private IProductRepository productoRepositoryImpl;


    @BeforeEach
    void setUp() {
        productoRepositoryImpl = new ProductoRepositoryImpl();
        ProductoRepositoryImpl.listProducts = new ArrayList<>();
        ProductoRepositoryImpl.count = new AtomicInteger(0);
    }

    @Test
    @DisplayName("Test Create Products")
    void createProductTest() {
        //Arrange
        Product product = Data.PRODUCT_MOTORING;

        //Act
        Product result = productoRepositoryImpl.createProduct(product);

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(1, result.getProductId()),
                () -> assertEquals(product.getProductName(), result.getProductName()),
                () -> assertEquals(product.getType(), result.getType()),
                () -> assertEquals(product.getBrand(), result.getBrand()),
                () -> assertEquals(product.getColor(), result.getColor()),
                () -> assertEquals(product.getNotes(), result.getNotes())
        );
    }


    @Test
    @DisplayName("Test Get All Products")
    void getAllProductsTest() {
        //Arrange
        Product product1 = Data.PRODUCT_MOTORING;
        Product product2 = Data.PRODUCT_SPORT;
        Product product3 = Data.PRODUCT_TECHNOLOGY;

        productoRepositoryImpl.createProduct(product1);
        productoRepositoryImpl.createProduct(product2);
        productoRepositoryImpl.createProduct(product3);

        //Act
        List<Product> list = productoRepositoryImpl.getAllProducts();

        //Assert
        assertAll(
                () -> assertTrue(!list.isEmpty()),
                () -> assertEquals(3, list.size()),
                () -> assertEquals(2, list.get(1).getProductId()),
                () -> assertEquals(product2.getProductName(), list.get(1).getProductName()),
                () -> assertEquals(product2.getType(), list.get(1).getType()),
                () -> assertEquals(product2.getBrand(), list.get(1).getBrand()),
                () -> assertEquals(product2.getColor(), list.get(1).getColor()),
                () -> assertEquals(product2.getNotes(), list.get(1).getNotes())
        );
    }


    @Test
    @DisplayName("Test Get Producto By id")
    void getProductByIdTest() {
        //Arrange
        Product product1 = Data.PRODUCT_MOTORING;
        Product product2 = Data.PRODUCT_SPORT;
        Product product3 = Data.PRODUCT_TECHNOLOGY;

        productoRepositoryImpl.createProduct(product1);
        productoRepositoryImpl.createProduct(product2);
        productoRepositoryImpl.createProduct(product3);

        //Act
        Product motoring = productoRepositoryImpl.getProductById(1);

        //Assert
        assertAll(
                () -> assertEquals(1, motoring.getProductId()),
                () -> assertEquals(product1.getProductName(), motoring.getProductName()),
                () -> assertEquals(product1.getType(), motoring.getType()),
                () -> assertEquals(product1.getBrand(), motoring.getBrand()),
                () -> assertEquals(product1.getColor(), motoring.getColor()),
                () -> assertEquals(product1.getNotes(), motoring.getNotes())
        );
    }


    @Test
    @DisplayName("Test Get Producto By id Not Found")
    void getProductByIdNotFound() {
        //Arrange
        Product product1 = Data.PRODUCT_MOTORING;
        Product product2 = Data.PRODUCT_SPORT;
        Product product3 = Data.PRODUCT_TECHNOLOGY;

        productoRepositoryImpl.createProduct(product1);
        productoRepositoryImpl.createProduct(product2);
        productoRepositoryImpl.createProduct(product3);

        //Act
        Product result = productoRepositoryImpl.getProductById(4);

        //Assert
        assertNull(result);

    }


    @Test
    @DisplayName("Test Get Producto By Name")
    void getProductByNameTest() {
        //Arrange
        Product product1 = Data.PRODUCT_MOTORING;
        Product product2 = Data.PRODUCT_SPORT;
        Product product3 = Data.PRODUCT_TECHNOLOGY;

        productoRepositoryImpl.createProduct(product1);
        productoRepositoryImpl.createProduct(product2);
        productoRepositoryImpl.createProduct(product3);

        //Act
        Product result = productoRepositoryImpl.getProductByName("Macbook Pro");

        //Assert
        assertAll(
                () -> assertEquals(3, result.getProductId()),
                () -> assertEquals(product3.getProductName(), result.getProductName()),
                () -> assertEquals(product3.getType(), result.getType()),
                () -> assertEquals(product3.getBrand(), result.getBrand()),
                () -> assertEquals(product3.getColor(), result.getColor()),
                () -> assertEquals(product3.getNotes(), result.getNotes())
        );
    }


    @Test
    @DisplayName("Test Get Category By Name Not Found")
    void getCategoryByNameNotFoundTest() {
        //Arrange
        Product product1 = Data.PRODUCT_MOTORING;
        Product product2 = Data.PRODUCT_SPORT;
        Product product3 = Data.PRODUCT_TECHNOLOGY;

        productoRepositoryImpl.createProduct(product1);
        productoRepositoryImpl.createProduct(product2);
        productoRepositoryImpl.createProduct(product3);


        //Act
        Product result = productoRepositoryImpl.getProductByName("Macbook");

        //Assert
        assertNull(result);

    }
}