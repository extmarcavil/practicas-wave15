package com.bootcamp.elastic.reposaitory;

import com.bootcamp.elastic.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
}
