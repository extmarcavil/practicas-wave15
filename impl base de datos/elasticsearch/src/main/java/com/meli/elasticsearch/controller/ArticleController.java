package com.meli.elasticsearch.controller;

import com.meli.elasticsearch.domain.Article;
import com.meli.elasticsearch.dto.ArticleDto;
import com.meli.elasticsearch.elastic.ElasticQueryFilter;
import com.meli.elasticsearch.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/elastic/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping()
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("{title}")
    public List<Article> findByTitle(@PathVariable String title) {
        return articleService.findByTitle(title);
    }

    @GetMapping("query")
    public SearchHits<Article> findDocumentWithQuery(@Valid @RequestBody ElasticQueryFilter<ArticleDto> elasticQuery) {
        return articleService.findDocumentsWithQuery(elasticQuery);
    }
}
