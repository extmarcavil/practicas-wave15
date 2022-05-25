package com.bootcamp.ejercitacion.service;

import com.bootcamp.ejercitacion.dto.ProductDTO;
import com.bootcamp.ejercitacion.entity.Product;
import com.bootcamp.ejercitacion.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productDTO = modelMapper.map(productRepository.save(product), ProductDTO.class);
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        if(productRepository.existsById(id)){
            Product product = modelMapper.map(productDTO, Product.class);
            product.setId(id);
            productDTO = modelMapper.map(productRepository.save(product),ProductDTO.class);
            return productDTO;
        }else{
            return null;
        }
    }
}
