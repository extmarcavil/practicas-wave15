package com.ejercicio.ElasticSearchProducts.repository;

import com.ejercicio.ElasticSearchProducts.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    @Override
    List<Product> findAll();

    Product findByName(String name);

}
