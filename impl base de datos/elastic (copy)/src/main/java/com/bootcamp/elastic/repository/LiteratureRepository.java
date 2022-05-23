package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
/*    @Override
    List<Literature> findAll();*/

    List<Literature> findAllByAuthor(String name);
    List<Literature> findAllByTitleLike(String title);
    List<Literature> findAllByCantPagesGreaterThan(int amount);
    List<Literature> findAllByFirstPostBefore(LocalDate year);
    List<Literature> findAllByFirstPostAfter(LocalDate year);
    List<Literature> findAllByEditorial(String edit);
 }
