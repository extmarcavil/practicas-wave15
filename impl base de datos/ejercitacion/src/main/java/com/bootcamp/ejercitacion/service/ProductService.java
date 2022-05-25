package com.bootcamp.ejercitacion.service;

import com.bootcamp.ejercitacion.dto.ProductDTO;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO updateProduct (String id, ProductDTO productDTO);
}
