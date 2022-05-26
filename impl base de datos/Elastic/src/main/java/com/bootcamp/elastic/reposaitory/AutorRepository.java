package com.bootcamp.elastic.reposaitory;

import com.bootcamp.elastic.domain.Autor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends ElasticsearchRepository<Autor, String> {
}
