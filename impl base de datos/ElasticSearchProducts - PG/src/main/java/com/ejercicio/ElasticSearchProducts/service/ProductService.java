package com.ejercicio.ElasticSearchProducts.service;

import com.ejercicio.ElasticSearchProducts.dto.request.ProductRequestDTO;
import com.ejercicio.ElasticSearchProducts.dto.response.ProductResponseDTO;
import com.ejercicio.ElasticSearchProducts.entity.Product;
import com.ejercicio.ElasticSearchProducts.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    ProductRepository productRepository;
    ModelMapper mapper;

    public ProductService(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }


    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        Product productModel = mapper.map(productRequestDTO, Product.class);
        productRepository.save(productModel);
        return mapper.map(productModel, ProductResponseDTO.class);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponseDTO modifyProduct(String name, ProductRequestDTO productRequestDTO) {
        Product productModel = productRepository.findByName(name);
        mapper.map(productRequestDTO, productModel);
        productRepository.save(productModel);
        return mapper.map(productModel, ProductResponseDTO.class);
    }
}
