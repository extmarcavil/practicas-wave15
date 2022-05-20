package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {

    @Override
    Literature save(Literature literature);

    @Override
    List<Literature> findAll();

    List<Literature> findByAuthorLike(String author);

    List<Literature> findByTitleIsIn(List<String> word);

    List<Literature> findByCantPagesGreaterThan(Integer cant);

    List<Literature> findByFirstPostBefore(LocalDate date);

    List<Literature> findByFirstPostAfter(LocalDate date);

    List<Literature> findByEditorial(String editorial);

}
