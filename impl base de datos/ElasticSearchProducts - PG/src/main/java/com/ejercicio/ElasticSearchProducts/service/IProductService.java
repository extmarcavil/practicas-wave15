package com.ejercicio.ElasticSearchProducts.service;

import com.ejercicio.ElasticSearchProducts.dto.request.ProductRequestDTO;
import com.ejercicio.ElasticSearchProducts.dto.response.ProductResponseDTO;
import com.ejercicio.ElasticSearchProducts.entity.Product;

import java.util.List;

public interface IProductService {

    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);

    List<Product> findAll();

    ProductResponseDTO modifyProduct(String name, ProductRequestDTO productRequestDTO);
}
