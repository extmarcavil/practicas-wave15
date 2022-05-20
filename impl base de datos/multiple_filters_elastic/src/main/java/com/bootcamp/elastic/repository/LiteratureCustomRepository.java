package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureCustomRepository {
    List<Literature> findAllLiteratureWithFilters(String author, String title, Integer minPages, LocalDate minYear, LocalDate maxYear, String byPublisher);

}
