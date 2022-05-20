package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
    List<Literature> findLiteratureByAuthorEquals(String autor);
    List<Literature> findLiteratureByTitleContaining(String word);
    List<Literature> findLiteratureByCantPagesGreaterThan(Integer pages);
    List<Literature> findLiteratureByFirstPostBefore(LocalDate date);
    List<Literature> findLiteratureByFirstPostAfter(LocalDate date);
    List<Literature> findLiteratureByEditorialEquals(String editorial);
}
