package com.meli.elasticsearch.repository;

import com.meli.elasticsearch.domain.Clothe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClotheRepository extends GenericElasticsearchRepository<Clothe> {

    Optional<Clothe> findByCode(UUID code);

    void deleteByCode(UUID code);

    List<Clothe> findAllBySize(String size);

    List<Clothe> findAllByNameContainingIgnoreCase(String name);

}
