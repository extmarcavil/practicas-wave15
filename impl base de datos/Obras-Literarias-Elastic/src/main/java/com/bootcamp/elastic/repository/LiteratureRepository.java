package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.dto.response.BookResponseDTO;
import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
/*    @Override
    List<Literature> findAll();*/

    List<Literature> findAllByAuthor(String autor);
    List<Literature> findAllByTitleContaining(String title);
    List<Literature> findAllByCantPagesGreaterThan(Integer cantPages);
    List<Literature> findAllByEditorial(String editorial);
    List<Literature> findAllByFirstPostBefore(LocalDate date);
    List<Literature> findAllByFirstPostAfter(LocalDate date);
}
