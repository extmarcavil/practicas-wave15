package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {

    @Override
    List<Literature> findAll();

    List<Literature> findAllByAuthor(String author);

    List<Literature> findAllByTitleIn(List<String> list);

    List<Literature> findAllByCantPagesGreaterThan(Integer cantPages);

    List<Literature> findAllByFirstPostBefore(LocalDate firstPost);

    List<Literature> findAllByFirstPostAfter(LocalDate firstPost);

    List<Literature> findAllByEditorial(String editorial);
}
