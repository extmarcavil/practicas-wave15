package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
    List<Literature> findLiteratureByAuthor(String author);

    List<Literature> findAllByTitleContainsIgnoreCase(String text);
    List<Literature> findAllByCantPagesGreaterThan(Integer pages);

    List<Literature> findAllByFirstPostBefore(LocalDate date);
    List<Literature> findAllByFirstPostAfter(LocalDate date);

    List<Literature> findLiteratureByEditorial(String editorial);
}
