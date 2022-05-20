package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
    List<Literature> findByAuthor(String author);

    List<Literature> findByTitleLike(List<String> words);

    List<Literature> findByCantPagesGreaterThan(Integer cantPages);

    List<Literature> findByFirstPostBefore(LocalDate date);

    List<Literature> findByFirstPostAfter(LocalDate date);

    List<Literature> findByEditorial(String editorial);
/*    @Override
    List<Literature> findAll();*/
}
