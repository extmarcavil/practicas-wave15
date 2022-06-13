package com.mercadolibre.fp_be_java_hisp_w15_g05.unit.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.BatchDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.BatchStockDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response.ProductDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.*;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.BatchRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.IProductRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.ISectionTypeRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.UserRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.ProductService;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.SessionServiceImpl;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.BatchFactory;
import com.mercadolibre.fp_be_java_hisp_w15_g05.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    IProductRepository productRepository;
    @Mock
    ISectionTypeRepository sectionTypeRepository;
    @Mock
    SessionServiceImpl sessionService;
    @Mock
    UserRepository userRepository;
    @Mock
    BatchRepository batchRepository;
    @InjectMocks
    ProductService productService;

    @Test
    @DisplayName("Test get lista de productos completa")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void verificarListaProductos(){
        //arrange
        List<ProductDTO> prodList = ProductFactory.getListProducts();

        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        //act
        when(productRepository.findAll()).thenReturn(ProductFactory.getListProducts2());
        List<ProductDTO> resp = productService.getListProducts(null,"Bearer ");
        //assert
        assertEquals(prodList, resp);
    }

    @Test
    @DisplayName("Test get lista de productos por sección")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void verificarListaProductosConSection(){
        //arrange
        List<ProductDTO> prodList3 = ProductFactory.getListProductsSection3();
        List<ProductDTO> prodList2 = ProductFactory.getListProductsSection2();
        List<ProductDTO> prodList1 = ProductFactory.getListProductsSection1();

        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);
        //act
        when(sectionTypeRepository.findByType(SectionTypeE.REFRIGERATED)).thenReturn(Optional.of(ProductFactory.Refrigerated));
        when(productRepository.findAllByType(ProductFactory.Refrigerated)).thenReturn(ProductFactory.getListProductsRefrigerated());
        List<ProductDTO> respRefrigerated = productService.getListProducts(3,"Bearer ");

        when(sectionTypeRepository.findByType(SectionTypeE.FROZEN)).thenReturn(Optional.of(ProductFactory.Frozen));
        when(productRepository.findAllByType(ProductFactory.Frozen)).thenReturn(ProductFactory.getListProductsFrozen());
        List<ProductDTO> respFrozen = productService.getListProducts(2,"Bearer ");

        when(sectionTypeRepository.findByType(SectionTypeE.FRESH)).thenReturn(Optional.of(ProductFactory.Fresh));
        when(productRepository.findAllByType(ProductFactory.Fresh)).thenReturn(ProductFactory.getListProductsFresh());
        List<ProductDTO> respFresh = productService.getListProducts(1,"Bearer ");
        //assert
        assertEquals(prodList3, respRefrigerated);
        assertEquals(prodList2, respFrozen);
        assertEquals(prodList1, respFresh);
    }

    @Test
    @DisplayName("Test excepción de lista no existente")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void verificarExcepciones(){
        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);
        //act
        when(productRepository.findAll()).thenReturn(ProductFactory.getEmptyList());
        //assert
        assertThrows(ListNotFoundException.class, ()->productService.getListProducts(null,"Bearer "));

    }

    @Test
    @DisplayName("Test excepción de sección no existente")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void verificarExcepciones2(){
        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);
        //assert
        assertThrows(WrongSectionTypeException.class, ()->productService.getListProducts(4,"Bearer "));

    }

    @Test
    @DisplayName("Trae producto con dato")
    void testGetExistingProduct() {
        Product product = new Product();
        product.setBatchList(new ArrayList<>());
        product.setName("Leche");
        product.setProduct_id(1);
        product.setPurchaseOrderProductByNumber(new ArrayList<>());
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(product, this.productService.findById(1));
        verify(this.productRepository).findById((Integer) any());
    }


    @Test
    @DisplayName("Excepcion si esta vacio")
    void testGetExistingProduct2() {
        when(this.productRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, () -> this.productService.findById(1));
        verify(this.productRepository).findById((Integer) any());
    }


    @Test
    @DisplayName("Excepcion por campo invalido")
    void testGetExistingProduct3() {
        when(this.productRepository.findById((Integer) any())).thenThrow(new InvalidFieldException("An error occurred"));
        assertThrows(InvalidFieldException.class, () -> this.productService.findById(1));
        verify(this.productRepository).findById((Integer) any());
    }

    @Test
    @DisplayName("Obtener stock de productos en lotes")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void getListProductFromBatch(){

        Integer idRequest = 1;
        String orderRequest = "L";
        Batch batch = BatchFactory.getBatch();

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        Product product = ProductFactory.getProducto();

        when(productRepository.findById(idRequest)).thenReturn(Optional.of(product));
        List<Batch> batchs = new ArrayList<>();
        batchs.add(batch);
        when(batchRepository.findAllByProductId(product)).thenReturn(batchs);

        BatchStockDTO response = productService.getListOfProductInBatch(idRequest, orderRequest, "Bearer ");

        assertEquals(idRequest, response.getProduct_id());
        assertEquals(1, response.getBatch_stock().size());
    }

    @Test
    @DisplayName("Obtener stock de productos en lotes")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void getListProductFromBatchWithOrderF(){

        Integer idRequest = 1;
        String orderRequest = "F";
        Batch batch = BatchFactory.getBatch();

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        Product product = ProductFactory.getProducto();

        when(productRepository.findById(idRequest)).thenReturn(Optional.of(product));
        List<Batch> batchs = new ArrayList<>();
        batchs.add(batch);
        when(batchRepository.findAllByProductId(product)).thenReturn(batchs);

        BatchStockDTO response = productService.getListOfProductInBatch(idRequest, orderRequest, "Bearer ");

        assertEquals(idRequest, response.getProduct_id());
        assertEquals(1, response.getBatch_stock().size());
    }

    @Test
    @DisplayName("Obtener stock de productos en lotes")
    @MockitoSettings(strictness = Strictness.LENIENT)
    void getListProductFromBatchWithOrderC(){

        Integer idRequest = 1;
        String orderRequest = "C";
        Batch batch = BatchFactory.getBatch();

        User user = new User(1L, new UserRol(1L, RolE.REP), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        Product product = ProductFactory.getProducto();

        when(productRepository.findById(idRequest)).thenReturn(Optional.of(product));
        List<Batch> batchs = new ArrayList<>();
        batchs.add(batch);
        when(batchRepository.findAllByProductId(product)).thenReturn(batchs);

        BatchStockDTO response = productService.getListOfProductInBatch(idRequest, orderRequest, "Bearer ");

        assertEquals(idRequest, response.getProduct_id());
        assertEquals(1, response.getBatch_stock().size());
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    public void validateRol() {
        Integer idRequest = 1;
        String orderRequest = "C";
        Batch batch = BatchFactory.getBatch();

        User user = new User(1L, new UserRol(1L, RolE.BUYER), "", "");
        when(sessionService.getUsername("")).thenReturn("user");
        when(userRepository.findByUsername("user")).thenReturn(Optional.of(user));
        when(sessionService.getUserByName("user")).thenReturn(user);

        Assertions.assertThrows(
                InvalidRolException.class,
                () -> productService.getListOfProductInBatch(idRequest, orderRequest, "Bearer "));
    }


}



