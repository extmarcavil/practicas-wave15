package com.social.media.sprgbt.service.impl;

import com.social.media.sprgbt.dto.ProductoDto;
import com.social.media.sprgbt.entity.Product;
import com.social.media.sprgbt.exception.ExistingException;
import com.social.media.sprgbt.exception.NotFoundException;
import com.social.media.sprgbt.mapper.ProductoMapper;
import com.social.media.sprgbt.repository.IProductRepository;
import com.social.media.sprgbt.service.IProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements IProductoService {

    /**
     * Instancia del Producto Repository
     */
    private final IProductRepository productRepository;

    /**
     * Instancia Producto Mapper.
     */
    private final ProductoMapper productoMapper;

    /**
     * Inyeccion por constructor.
     *
     * @param productRepository
     * @param productoMapper
     */
    public ProductServiceImpl(IProductRepository productRepository, ProductoMapper productoMapper) {
        this.productRepository = productRepository;
        this.productoMapper = productoMapper;
    }


    /**
     * Create Product
     *
     * @param dto
     * @return {@link ProductoDto} obj
     * @throws ExistingException
     */
    @Override
    public ProductoDto createProduct(ProductoDto dto) throws ExistingException {

        if (productRepository.getProductByName(dto.getProductName()) != null) {
            throw new ExistingException(String.format("El Producto con nameProduct: %s ya existe en la BD.", dto.getProductName()));
        }

        Product entity = productoMapper.mapToEntity(dto);

        Product newEntity = productRepository.createProduct(entity);

        return productoMapper.mapToDto(newEntity);
    }

    /**
     * Get All Productos
     *
     * @return
     */
    @Override
    public List<ProductoDto> getAllProducts() {
        List<Product> listEntity = productRepository.getAllProducts();

        List<ProductoDto> listDto = listEntity.stream()
                .map(p -> productoMapper.mapToDto(p))
                .collect(Collectors.toList());

        return listDto;
    }

    /**
     * Get Product By Id
     *
     * @param id
     * @return {@link ProductoDto} obj
     * @throws NotFoundException
     */
    @Override
    public ProductoDto getProductById(Integer id) throws NotFoundException {

        Product product = productRepository.getProductById(id);

        if (product == null) {
            throw new NotFoundException(String.format("El Producto con iD: %s no existe en la BD.", id));
        }

        log.info("Product: {}", product);

        return productoMapper.mapToDto(product);
    }

    /**
     * Get Product By Name
     *
     * @param productName param
     * @return {@link ProductoDto} obj
     * @throws NotFoundException exception
     */
    @Override
    public ProductoDto getProductByName(String productName) throws NotFoundException {

        Product product = productRepository.getProductByName(productName);

        if (product == null) {
            throw new NotFoundException(String.format("El Producto con productName: %s no existe en la BD.", productName));
        }

        log.info("Product: {}", product);

        return productoMapper.mapToDto(product);
    }

}
