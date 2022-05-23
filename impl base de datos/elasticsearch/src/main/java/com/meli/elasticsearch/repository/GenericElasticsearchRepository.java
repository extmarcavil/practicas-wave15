package com.meli.elasticsearch.repository;

import com.meli.elasticsearch.exception.ElasticElementNotFoundException;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@NoRepositoryBean
public interface GenericElasticsearchRepository<T> extends ElasticsearchRepository<T, String> {

    default T getEntity(String id) {
        return findById(id)
                .orElseThrow(() -> new ElasticElementNotFoundException(id));
    }

    default List<T> findAllEntities() {
        return stream(findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    default <R> R findByIdForUpdate(String elementId, Function<T, R> callback) {
        T entity = getEntity(elementId);

        return callback.apply(entity);
    }

}
