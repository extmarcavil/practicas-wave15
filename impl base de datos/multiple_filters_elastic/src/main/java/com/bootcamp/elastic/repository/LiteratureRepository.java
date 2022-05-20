package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LiteratureRepository extends LiteratureBasicRepository, LiteratureCustomRepository {
}
