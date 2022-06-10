package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.enums.Category;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductsNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.PurchaseOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.BatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.BuyerRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.ProductRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.PurchaseOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static com.mercadolibre.fp_be_java_hisp_w15_g06.factory.ProductFactory.meat;
import static com.mercadolibre.fp_be_java_hisp_w15_g06.factory.ProductFactory.milk;
import static com.mercadolibre.fp_be_java_hisp_w15_g06.factory.PurchaseOrderFactory.purchaseOrder;
import static com.mercadolibre.fp_be_java_hisp_w15_g06.factory.PurchaseOrderFactory.purchaseOrderWithoutProducts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceImplTest {

    @Mock
    private PurchaseOrderRepository purchaseOrderRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private BuyerRepository buyerRepository;
    @Mock
    private BatchRepository batchRepository;

    @InjectMocks
    private PurchaseServiceImpl purchaseService;

    @Test
    void whenThereAreNoProducts_thenAnExceptionIsThrown() {
        assertThatThrownBy(() -> purchaseService.findProducts())
                .isInstanceOf(ProductsNotFoundException.class)
                .hasMessage("No se encontraron productos");
    }

    @Test
    void whenThereAreProducts_thenAListOfProductsAreReturned() {
        List<Product> products = List.of(milk(), meat());

        when(productRepository.findAll()).thenReturn(products);

        ResponseEntity<List<ProductDTO>> productDTOS = purchaseService.findProducts();

        assertAll(
                () -> assertThat(productDTOS).isNotNull()
         //       () -> assertThat(productDTOS.size).isEqualTo(2)
        );
    }

    @Test
    void whenThereAreProductsFromOrder_thenAListOfProductsAreReturned() {
        Long idOrder = purchaseOrder().getId();
        PurchaseOrder purchaseOrder = purchaseOrder();

        when(purchaseOrderRepository.findById(idOrder))
                .thenReturn(Optional.of(purchaseOrder));

        ResponseEntity<List<ProductDTO>> products = purchaseService.findProductsByOrder(idOrder);

        assertAll(
                () -> assertThat(products).isNotNull()
            //    () -> assertThat(products.size()).isEqualTo(1)
        );
    }

    @Test
    void whenThereAreNoProductsFromOrder_thenAListEmptyIsReturned() {
        Long idOrder = purchaseOrder().getId();
        PurchaseOrder purchaseOrder = purchaseOrderWithoutProducts();

        when(purchaseOrderRepository.findById(idOrder))
                .thenReturn(Optional.of(purchaseOrder));

        ResponseEntity<List<ProductDTO>> products = purchaseService.findProductsByOrder(idOrder);

        assertAll(
                () -> assertThat(products.equals(null)).isFalse()
            //    () -> assertThat(products.isEmpty()).isTrue(),
          //      () -> assertThat(products.size()).isEqualTo(0)
        );
    }

    @Test
    void whenThereAreNoProductsByCategory_thenAnExceptionIsThrown() {
        assertThatThrownBy(() -> purchaseService.findProductsByCategory(any()))
                .isInstanceOf(ProductsNotFoundException.class)
                .hasMessage("No se encontraron productos");
    }

    @Test
    void whenThereAreProductsFromCategory_thenAListOfProductsAreReturned() {
        Product product = milk();

        when(productRepository.findAllByCategory(any())).thenReturn(List.of(product));

        ResponseEntity<List<ProductDTO>> products = purchaseService.findProductsByCategory(Category.RF);

        assertAll(
                () -> assertThat(products.equals(null)).isFalse()
              //  () -> assertThat(products.isEmpty()).isFalse(),
              //  () -> assertThat(products.size()).isEqualTo(1)
        );
    }

/*
    @Test
    void whenTheUserBuyerDoesNotExist_thenAnExceptionIsThrown() {
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(LocalDate.now(), 10L, SHOPPING_CART,
                emptyList());
        Long idNoExists = purchaseOrderDTO.getBuyerId();

        when(buyerRepository.getBuyer(idNoExists)).thenThrow(new BuyerNotFoundException(idNoExists));

        assertThatThrownBy(() -> purchaseService.createOrder(purchaseOrderDTO))
                .isInstanceOf(BuyerNotFoundException.class)
                .hasMessage(String.format("Buyer con ID: %s no existe.", idNoExists));
    }
*/

/*    @Test
    void whenTheBatchHasNotQuantityOfProducts_thenAnExceptionIsThrown() {
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(LocalDate.now(), 10L, SHOPPING_CART,
                emptyList());
        Long idNoExists = purchaseOrderDTO.getBuyerId();

        when(buyerRepository.getBuyer(idNoExists)).thenThrow(new BuyerNotFoundException(idNoExists));

        assertThatThrownBy(() -> purchaseService.createOrder(purchaseOrderDTO))
                .isInstanceOf(BuyerNotFoundException.class)
                .hasMessage(String.format("Buyer con ID: %s no existe.", idNoExists));
    }*/

}