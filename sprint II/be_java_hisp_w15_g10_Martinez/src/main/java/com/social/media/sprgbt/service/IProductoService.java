package com.social.media.sprgbt.service;

import com.social.media.sprgbt.dto.ProductoDto;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;

import java.util.List;

public interface IProductoService {

    /**
     * Create Product
     *
     * @param dto param
     * @return {@link ProductoDto} obj
     * @throws ExistingException exception
     */
    ProductoDto createProduct(ProductoDto dto) throws ExistingException;

    /**
     * Get All Products
     *
     * @return {@link ProductoDto} list
     */
    List<ProductoDto> getAllProducts();

    /**
     * Get Product By Id
     *
     * @param id param
     * @return {@link ProductoDto} obj
     * @throws NotFoundException exception
     */
    ProductoDto getProductById(Integer id) throws NotFoundException;

    /**
     * Get Product By Name
     *
     * @param productName param
     * @return {@link ProductoDto} obj
     * @throws NotFoundException exception
     */
    ProductoDto getProductByName(String productName) throws NotFoundException;

}
