package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
/*    @Override
    List<Literature> findAll();*/

    //1) Retornar las obras de un autor dado por el usuario.
    List<Literature> findAllByAuthorLike(String author);

    //2) Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    //@Query("{\"bool\": {\"must\": {\"terms\": {\"your_field_name\":?0}}}}")
    List<Literature> findAllByTitleIn(List<String> title);

    //3) Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    List<Literature> findAllByCantPagesGreaterThan(Integer cantPages);

    //4) Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    List<Literature> findAllByFirstPostBefore(LocalDate date);
    List<Literature> findAllByFirstPostAfter(LocalDate date);

    //5) Retornar las obras de una misma editorial.
    List<Literature> findAllByEditorialLike(String editorial);
}
