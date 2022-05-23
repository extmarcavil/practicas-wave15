package com.meli.elasticsearch.service;

import com.meli.elasticsearch.domain.LiteraryWork;
import com.meli.elasticsearch.dto.LiteraryWorkDto;
import com.meli.elasticsearch.repository.GenericElasticsearchRepository;
import com.meli.elasticsearch.repository.LiteraryWorkRepository;
import com.meli.elasticsearch.utils.JsonAdapter;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class LiteraryWorkService extends ClientElasticService<LiteraryWorkDto, LiteraryWork> {

    private final LiteraryWorkRepository literaryWorkRepository;

    public LiteraryWorkService(ElasticsearchOperations elasticsearchOperations,
                               RestHighLevelClient client,
                               JsonAdapter adapter,
                               LiteraryWorkRepository literaryWorkRepository) {
        super(elasticsearchOperations, client, adapter);
        this.literaryWorkRepository = literaryWorkRepository;
    }

    @Override
    protected Map<String, Object> createParametersFrom(LiteraryWorkDto dto) {
        return null;
    }

    @Override
    protected LiteraryWork elementForSaveFrom(LiteraryWorkDto literaryWorkDto) {
        return null;
    }

    @Override
    protected LiteraryWork elementForUpdateFrom(LiteraryWorkDto literaryWorkDto) {
        return null;
    }

    @Override
    protected String index() {
        return LiteraryWork.INDEX;
    }

    @Override
    protected GenericElasticsearchRepository<LiteraryWork> repository() {
        return literaryWorkRepository;
    }

    @Override
    protected Class<LiteraryWork> entity() {
        return LiteraryWork.class;
    }

    public List<LiteraryWork> findAllByAuthor(String author) {
        return literaryWorkRepository.findAllByAuthor(author);
    }

    public List<LiteraryWork> findAllByName(String name) {
        return literaryWorkRepository.findAllByNameContainsIgnoreCase(name);
    }

    public List<LiteraryWork> findAllByMorePagesOf(Integer numberOfPages) {
        return literaryWorkRepository.findAllByNumberOfPagesGreaterThan(numberOfPages);
    }

    public List<LiteraryWork> findAllByYearOfPublicationBeforeOf(LocalDate yearOfPublication) {
        return literaryWorkRepository.findAllByYearOfPublicationBefore(yearOfPublication);
    }

    public List<LiteraryWork> findAllByYearOfPublicationAfterOf(LocalDate yearOfPublication) {
        return literaryWorkRepository.findAllByYearOfPublicationAfter(yearOfPublication);
    }

    public List<LiteraryWork> findAllByEditorial(String editorial) {
        return literaryWorkRepository.findAllByEditorial(editorial);
    }

    public List<LiteraryWorkDto> findAllAsDto() {
        return null;
    }

}