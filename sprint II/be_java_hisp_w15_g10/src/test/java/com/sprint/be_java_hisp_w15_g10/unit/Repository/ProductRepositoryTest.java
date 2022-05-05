package com.sprint.be_java_hisp_w15_g10.unit.Repository;

import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Repository.ProductRepository;
import com.sprint.be_java_hisp_w15_g10.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class ProductRepositoryTest {

    ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        productRepository = new ProductRepository();
    }

    @Test
    void getValidCategoryById() {
        // arrange
        Product product = TestUtils.createProduct();
        productRepository.add(product);

        //act
        Optional<Product> oProduct = productRepository.getById(6);

        // assert
        Assertions.assertEquals(oProduct.get(), product);
    }

    @Test
    void getInvalidUserById() {
        // arrange
        productRepository.add(TestUtils.createProduct());
        //act
        Optional<Product> product = productRepository.getById(10);

        // assert
        Assertions.assertTrue(product.isEmpty());
    }

    @Test
    void getAll() {
        // arrange
        productRepository.add(TestUtils.createProduct());

        //act
        List<Product> products = productRepository.getAll();

        // assert
        Assertions.assertAll(
                ()->{Assertions.assertFalse(products.isEmpty());},
                ()->{Assertions.assertEquals(products.size(),6);}
        );
    }

    @Test
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
                ()->{Assertions.assertEquals(initial_size + 1, final_size);},
                ()->{Assertions.assertEquals(product, productRepository.getById(6).get());}
        );
    }
}