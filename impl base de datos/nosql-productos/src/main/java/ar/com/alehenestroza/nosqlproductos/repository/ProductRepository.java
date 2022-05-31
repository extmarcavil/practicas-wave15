package ar.com.alehenestroza.nosqlproductos.repository;

import ar.com.alehenestroza.nosqlproductos.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
