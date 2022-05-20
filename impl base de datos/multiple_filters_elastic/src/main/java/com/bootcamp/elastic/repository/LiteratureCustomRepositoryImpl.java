package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.*;

public class LiteratureCustomRepositoryImpl implements LiteratureCustomRepository {
    private ElasticsearchOperations esTemplate;

    public LiteratureCustomRepositoryImpl(ElasticsearchOperations esTemplate) {
        this.esTemplate = esTemplate;
    }

    @Override
    public List<Literature> findAllLiteratureWithFilters(String author, String title, Integer minPages, LocalDate minYear, LocalDate maxYear, String byPublisher) {
        BoolQueryBuilder searchQueryBuilder = QueryBuilders.boolQuery();

        if(author != null)
            searchQueryBuilder.must(matchQuery("author", author));

        if(title != null)
            // Esto debería ser un termsMatch que recibiera una lista de palabras que podrían estar en el título, no un match exacto de un string
            searchQueryBuilder.must(matchQuery("title", title));

        if(minPages != null)
            searchQueryBuilder.must(rangeQuery("cantPages").gt(minPages));

        if(minYear != null)
            searchQueryBuilder.must(rangeQuery("firstPost").gte(minYear));

        if(maxYear != null)
            searchQueryBuilder.must(rangeQuery("firstPost").lte(maxYear));

        if(byPublisher != null)
            searchQueryBuilder.must(matchQuery("editorial", byPublisher));

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(searchQueryBuilder).build();

        return esTemplate
                .search(searchQuery, Literature.class, IndexCoordinates.of("literature"))
                .getSearchHits()
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }

}
