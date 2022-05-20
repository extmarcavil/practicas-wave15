package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.EmployeeDto;
import com.bootcamp.elastic.dto.ProductDto;
import com.bootcamp.elastic.model.Employee;
import com.bootcamp.elastic.model.Product;
import com.bootcamp.elastic.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
        mapper = new ModelMapper();
    }

    @Override
    public ProductDto save(ProductDto product) {
        return mapper.map(
                productRepository.save(mapper.map(product, Product.class)),
                ProductDto.class);
    }
}
