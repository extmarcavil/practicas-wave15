package com.sprint.be_java_hisp_w15_g10.unit.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Repository.ProductRepository;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class ProductRepositoryTest {

    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    /**
     * Valida que se pueda obtener un producto valido dado un id valido
     */
    @Test
    @DisplayName("Test obtener un producto valido por id")
    void getValidProductById() {
        // arrange
        Product product = TestUtils.createProduct();
        productRepository.add(product);

        //act
        Optional<Product> oProduct = productRepository.getById(6);

        // assert
        Assertions.assertEquals(oProduct.get(), product);
        Assertions.assertEquals(oProduct.get().getProduct_name(), product.getProduct_name());
        Assertions.assertEquals(oProduct.get().getType(), product.getType());
        Assertions.assertEquals(oProduct.get().getColor(), product.getColor());
        Assertions.assertEquals(oProduct.get().getBrand(), product.getBrand());
        Assertions.assertEquals(oProduct.get().getNotes(), product.getNotes());
    }

    /**
     * Valida que no se pueda obtener un producto dado un id invalido
     *
     */
    @Test
    @DisplayName("Test obtener un producto invalido por id")
    void getInvalidUserById() {
        // arrange
        productRepository.add(TestUtils.createProduct());
        //act
        Optional<Product> product = productRepository.getById(10);

        // assert
        Assertions.assertTrue(product.isEmpty());
    }

    /**
     * Validar que se pueda obtener todos los productos del repositorio
     *
     */
    @Test
    @DisplayName("Test obtener todos los productos")
    void getAll() {
        // arrange
        productRepository.add(TestUtils.createProduct());

        //act
        List<Product> products = productRepository.getAll();

        // assert
        Assertions.assertAll(
                () -> {
                    Assertions.assertFalse(products.isEmpty());
                },
                () -> {
                    Assertions.assertEquals(products.size(), 6);
                }
        );
    }

    /**
     * Valida que se pueda agregar un nuevo producto al repositorio
     *
     */
    @Test
    @DisplayName("Test agregar un producto")
    void add() {
        // arrange
        Product product = TestUtils.createProduct();
        productRepository.add(product);
        int initial_size = productRepository.getAll().size();
        // act
        productRepository.add(product);
        int final_size = productRepository.getAll().size();
        // assert
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(initial_size + 1, final_size);
                },
                () -> {
                    Assertions.assertEquals(product, productRepository.getById(6).get());
                }
        );
    }
}