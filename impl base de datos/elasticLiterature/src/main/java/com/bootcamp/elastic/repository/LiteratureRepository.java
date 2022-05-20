package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {

    List<Literature> findAll();

    List<Literature> findAllByAuthor(String author);

    List<Literature> findAllByTitleIn(List<String> title);

    List<Literature> findAllByCantPagesAfter(Integer cantPage);
    List<Literature> findAllByFirstPostAfter(LocalDate date);

    List<Literature> findAllByFirstPostBefore(LocalDate fecha);

    List<Literature> findAllByEditorial(String editorial);
}
