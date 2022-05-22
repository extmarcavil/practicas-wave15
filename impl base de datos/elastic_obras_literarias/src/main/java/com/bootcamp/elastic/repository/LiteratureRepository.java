package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
    /**
     * Retornar todas las obras.
     *
     * @return List<Literature>
     */
    List<Literature> findAll();

    /**
     * Retornar las obras de un autor dado por el usuario.
     *
     * @return List<Literature>
     */
    List<Literature> findAllByAuthorLike(String author);

    /**
     * Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
     *
     * @return List<Literature>
     */
    List<Literature> findAllByTitleIn(List<String> titleWords);

    /**
     * Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
     *
     * @return List<Literature>
     */
    List<Literature> findAllByCantPagesGreaterThan(Integer pages);

    /**
     * Retornar las obras que fueron publicadas antes de un año dado por el usuario.
     *
     * @return List<Literature>
     */
    List<Literature> findAllByFirstPostBefore(LocalDate date);

    /**
     * Retornar las obras que fueron publicadas después de un año dado por el usuario.
     *
     * @return List<Literature>
     */
    List<Literature> findAllByFirstPostAfter(LocalDate date);

    /**
     * Retornar las obras de una misma editorial.
     *
     * @return List<Literature>
     */
    List<Literature> findAllByEditorial(String editorial);
}
