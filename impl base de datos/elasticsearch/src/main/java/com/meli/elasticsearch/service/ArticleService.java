package com.meli.elasticsearch.service;

import com.meli.elasticsearch.domain.Article;
import com.meli.elasticsearch.dto.ArticleDto;
import com.meli.elasticsearch.repository.ArticleRepository;
import com.meli.elasticsearch.repository.GenericElasticsearchRepository;
import com.meli.elasticsearch.utils.JsonAdapter;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService extends ClientElasticService<ArticleDto, Article> {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ElasticsearchOperations elasticsearchOperations,
                          RestHighLevelClient client,
                          ArticleRepository articleRepository,
                          JsonAdapter adapter) {
        super(elasticsearchOperations, client, adapter);
        this.articleRepository = articleRepository;
    }

    @Override
    protected Map<String, Object> createParametersFrom(ArticleDto dto) {
        return null;
    }

    @Override
    protected Article elementForSaveFrom(ArticleDto articleDto) {
        return null;
    }

    @Override
    protected Article elementForUpdateFrom(ArticleDto articleDto) {
        return null;
    }

    @Override
    protected String index() {
        return Article.INDEX;
    }

    @Override
    protected GenericElasticsearchRepository<Article> repository() {
        return articleRepository;
    }

    @Override
    protected Class<Article> entity() {
        return Article.class;
    }

    public List<Article> findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    public List<ArticleDto> findAllAsDto() {
        return null;
    }

}