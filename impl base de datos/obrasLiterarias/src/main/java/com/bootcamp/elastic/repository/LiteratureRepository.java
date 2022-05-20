package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;


public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
    List<Literature> findAllByAuthorLike (String author);
    List<Literature> findAllByTitleIn(List<String> words);
    List<Literature> findAllByCantPagesGreaterThan(Integer cantPages);
    List<Literature> findAllByFirstPostBefore(LocalDate date);
    List<Literature> findAllByFirstPostAfter(LocalDate date);
    List<Literature> findAllByEditorialLike(String editorial);
}
