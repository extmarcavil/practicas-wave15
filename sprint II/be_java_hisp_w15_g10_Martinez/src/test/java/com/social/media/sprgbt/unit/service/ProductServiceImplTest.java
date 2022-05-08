package com.social.media.sprgbt.unit.service;

import com.social.media.sprgbt.dto.ProductoDto;
import com.social.media.sprgbt.entity.Product;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.ProductoMapper;
import com.social.media.sprgbt.repository.IProductRepository;
import com.social.media.sprgbt.service.impl.ProductServiceImpl;
import com.social.media.sprgbt.utils.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    /**
     * Mocks
     */
    @Mock
    IProductRepository productRepository;

    @Mock
    private ProductoMapper productoMapper;

    @InjectMocks
    ProductServiceImpl productoServiceImpl;


    /**
     * Tests
     */
    @Test
    @DisplayName("Test Create Product")
    void createProductTest() {
        //Arrange
        when(productRepository.getProductByName(Data.PRODUCTDTO_TECHNOLOGY.getProductName()))
                .thenReturn(null);

        when(productoMapper.mapToEntity(Data.PRODUCTDTO_TECHNOLOGY)).thenReturn(Data.PRODUCT_TECHNOLOGY);

        when(productRepository.createProduct(Data.PRODUCT_TECHNOLOGY)).then(invocationOnMock -> {
            Data.PRODUCT_TECHNOLOGY.setProductId(1);
            return Data.PRODUCT_TECHNOLOGY;
        });

        when(productoMapper.mapToDto(Data.PRODUCT_TECHNOLOGY)).then(invocationOnMock -> {
            Data.PRODUCTDTO_TECHNOLOGY.setProductId(1);
            return Data.PRODUCTDTO_TECHNOLOGY;
        });

        //Act
        ProductoDto productResult = productoServiceImpl.createProduct(Data.PRODUCTDTO_TECHNOLOGY);

        //Assert
        assertAll(
                () -> assertNotNull(productResult),
                () -> assertEquals(1, productResult.getProductId()),
                () -> assertEquals(Data.PRODUCTDTO_TECHNOLOGY.getProductName(), productResult.getProductName()),
                () -> assertEquals(Data.PRODUCTDTO_TECHNOLOGY.getBrand(), productResult.getBrand()),
                () -> assertEquals(Data.PRODUCTDTO_TECHNOLOGY.getColor(), productResult.getColor()),
                () -> assertEquals(Data.PRODUCTDTO_TECHNOLOGY.getType(), productResult.getType()),
                () -> assertEquals(Data.PRODUCTDTO_TECHNOLOGY.getNotes(), productResult.getNotes())
        );

        verify(productRepository, atLeastOnce()).getProductByName(any(String.class));
        verify(productoMapper, atLeastOnce()).mapToEntity(any(ProductoDto.class));
        verify(productRepository, atLeastOnce()).createProduct(any(Product.class));
        verify(productoMapper, atLeastOnce()).mapToDto(any(Product.class));
    }

    @Test
    @DisplayName("Test Create Product Existing ")
    void createProductExistingTest() {
        //Arrange
        when(productRepository.getProductByName(Data.PRODUCTDTO_TECHNOLOGY.getProductName()))
                .thenReturn(Data.PRODUCT_TECHNOLOGY);

        //Act
        //Assert
        ExistingException e = assertThrows(ExistingException.class, () -> {
            productoServiceImpl.createProduct(Data.PRODUCTDTO_TECHNOLOGY);
        });
        assertEquals("El Producto con nameProduct: Macbook Pro ya existe en la BD.", e.getMessage());
        verify(productRepository, atLeastOnce()).getProductByName(any(String.class));

    }

    @Test
    @DisplayName("Test Get All Productos")
    void getAllProductsTest() {
        //Arrange
        Data.PRODUCT_SPORT.setProductId(1);
        when(productRepository.getAllProducts()).then(invocationOnMock -> {
            return List.of(Data.PRODUCT_SPORT);
        });

        when(productoMapper.mapToDto(Data.PRODUCT_SPORT)).then(invocationOnMock -> {
            Data.PRODUCTDTO_SPORT.setProductId(1);
            return Data.PRODUCTDTO_SPORT;
        });

        //Act
        List<ProductoDto> productsDtoResult = productoServiceImpl.getAllProducts();

        //Assert
        assertAll(
                () -> assertNotNull(productsDtoResult),
                () -> assertEquals(1, productsDtoResult.get(0).getProductId()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getProductName(), productsDtoResult.get(0).getProductName()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getBrand(), productsDtoResult.get(0).getBrand()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getType(), productsDtoResult.get(0).getType()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getColor(), productsDtoResult.get(0).getColor()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getNotes(), productsDtoResult.get(0).getNotes())
        );

        verify(productRepository, atLeastOnce()).getAllProducts();
        verify(productoMapper, atLeastOnce()).mapToDto(any(Product.class));

    }

    @Test
    @DisplayName("Test Get Product By Id")
    void getProductByIdTest() {
        //Arrange
        when(productRepository.getProductById(1)).then(invocationOnMock -> {
            Data.PRODUCT_SPORT.setProductId(1);
            return Data.PRODUCT_SPORT;
        });

        when(productoMapper.mapToDto(Data.PRODUCT_SPORT)).then(invocationOnMock -> {
            Data.PRODUCTDTO_SPORT.setProductId(1);
            return Data.PRODUCTDTO_SPORT;
        });

        //Act
        ProductoDto productsDtoResult = productoServiceImpl.getProductById(1);

        //Assert
        assertAll(
                () -> assertNotNull(productsDtoResult),
                () -> assertEquals(1, productsDtoResult.getProductId()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getProductName(), productsDtoResult.getProductName()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getBrand(), productsDtoResult.getBrand()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getType(), productsDtoResult.getType()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getColor(), productsDtoResult.getColor()),
                () -> assertEquals(Data.PRODUCTDTO_SPORT.getNotes(), productsDtoResult.getNotes())
        );


        verify(productRepository, atLeastOnce()).getProductById(anyInt());
        verify(productoMapper, atLeastOnce()).mapToDto(any(Product.class));
    }

    @Test
    @DisplayName("Test Get Product By Id Not Found")
    void getUserByProductNotFoundTest() {
        //Arrange
        when(productRepository.getProductById(10)).thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () ->
                productoServiceImpl.getProductById(10)
        );
        assertEquals("El Producto con iD: 10 no existe en la BD.", e.getMessage());
        verify(productRepository, atLeastOnce()).getProductById(anyInt());
    }


    @Test
    @DisplayName("Test Get User By Username")
    void getUserByUsernameTest() {
        //Arrange
        when(productRepository.getProductByName(anyString())).then(invocationOnMock -> {
            Data.PRODUCT_MOTORING.setProductId(1);
            return Data.PRODUCT_MOTORING;
        });

        when(productoMapper.mapToDto(Data.PRODUCT_MOTORING)).then(invocationOnMock -> {
            Data.PRODUCTDTO_MOTORING.setProductId(1);
            return Data.PRODUCTDTO_MOTORING;
        });

        //Act
        ProductoDto productDtoResult = productoServiceImpl.getProductByName(anyString());

        //Assert
        assertAll(
                () -> assertNotNull(productDtoResult),
                () -> assertEquals(1, productDtoResult.getProductId()),
                () -> assertEquals(Data.PRODUCT_MOTORING.getProductName(), productDtoResult.getProductName()),
                () -> assertEquals(Data.PRODUCT_MOTORING.getBrand(), productDtoResult.getBrand()),
                () -> assertEquals(Data.PRODUCT_MOTORING.getType(), productDtoResult.getType()),
                () -> assertEquals(Data.PRODUCT_MOTORING.getColor(), productDtoResult.getColor()),
                () -> assertEquals(Data.PRODUCT_MOTORING.getNotes(), productDtoResult.getNotes())
        );

        verify(productRepository, atLeastOnce()).getProductByName(any(String.class));
        verify(productoMapper, atLeastOnce()).mapToDto(any(Product.class));
    }


    @Test
    @DisplayName("Test Get User By Username Not Found")
    void getUserByUsernameNotFoundTest() {
        //Arrange
        when(productRepository.getProductByName(Data.PRODUCT_SPORT.getProductName())).thenReturn(null);

        //Act
        //Assert
        NotFoundException e = assertThrows(NotFoundException.class, () ->
                productoServiceImpl.getProductByName(Data.PRODUCT_SPORT.getProductName())
        );
        assertEquals("El Producto con productName: Ball no existe en la BD.", e.getMessage());
        verify(productRepository, atLeastOnce()).getProductByName(any(String.class));
    }


}