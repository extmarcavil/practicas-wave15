package com.meli.elasticsearch.service;

import com.meli.elasticsearch.domain.ElasticDocument;
import com.meli.elasticsearch.dto.ElasticDocumentDto;
import com.meli.elasticsearch.elastic.Pageable;
import com.meli.elasticsearch.elastic.QueryFilter;
import com.meli.elasticsearch.exception.ElasticDocumentAlreadyExistsException;
import com.meli.elasticsearch.repository.GenericElasticsearchRepository;
import com.meli.elasticsearch.utils.JsonAdapter;
import io.vavr.control.Try;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;
import static java.util.stream.Collectors.toMap;
import static org.elasticsearch.client.RequestOptions.DEFAULT;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termsQuery;

public abstract class ClientElasticService<DTO extends ElasticDocumentDto, T extends ElasticDocument> {

    protected final ElasticsearchOperations elasticsearchOperations;
    protected final RestHighLevelClient client;
    private final JsonAdapter adapter;

    public ClientElasticService(ElasticsearchOperations elasticsearchOperations,
                                RestHighLevelClient client,
                                JsonAdapter adapter) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.client = client;
        this.adapter = adapter;
    }

    public List<T> findAll() {
        return repository().findAllEntities();
    }

    public void save(DTO dto) {
        T elementToSave = getElementToSave(dto);

        repository().save(elementToSave);
    }

    private T getElementToSave(DTO dto) {
        String id = dto.getId();

        if (id != null && repository().existsById(id)) {
            throw new ElasticDocumentAlreadyExistsException(id);
        }

        return elementForSaveFrom(dto);
    }

    public void update(DTO dto) {
        T elementUpdated = elementForUpdateFrom(dto);

        Try.of(() -> updateDocumentFrom(elementUpdated))
                .recoverWith(err -> Match(err).of(
                        Case($(instanceOf(IllegalArgumentException.class)), this::handleJsonError),
                        Case($(instanceOf(ElasticsearchStatusException.class)), this::handleElasticsearchError),
                        Case($(instanceOf(IOException.class)), this::handleUpdateError),
                        Case($(), this::handleUnexpectedError)
                ));
    }

    public SearchHits<T> findDocumentsWithQuery(QueryFilter<DTO> queryElastic) {
        Query searchQuery = createQueryWithPageableFrom(queryElastic);

        return makeRequestWithQuery(searchQuery);
    }

    private QueryBuilder createQueryBuilderFrom(DTO dto) {
        Map<String, Object> parametersForQuery = createParametersFrom(dto);

        return addParametersForQueryBuilder(parametersForQuery);
    }

    private SearchHits<T> makeRequestWithQuery(Query searchQuery) {
        return elasticsearchOperations.search(
                searchQuery,
                entity(),
                IndexCoordinates.of(index())
        );
    }

    private NativeSearchQuery createNativeSearchQueryFrom(PageRequest pageRequest, QueryBuilder queryBuilder) {
        return new NativeSearchQueryBuilder()
                .withPageable(pageRequest)
                .withQuery(queryBuilder)
                .build();
    }

    private UpdateResponse updateDocumentFrom(T element) throws IOException {
        UpdateRequest request = createUpdateRequestFor(element);

        return client.update(request, DEFAULT);
    }

    private NativeSearchQuery createQueryWithPageableFrom(QueryFilter<DTO> queryElastic) {
        PageRequest pageRequest = createPageableFrom(queryElastic);
        QueryBuilder queryBuilder = createQueryBuilderFrom(queryElastic.getValue());

        return createNativeSearchQueryFrom(pageRequest, queryBuilder);
    }

    private UpdateRequest createUpdateRequestFor(T element) {
        return new UpdateRequest()
                .index(index())
                .id(element.getId())
                .doc(toJson(element), XContentType.JSON);
    }

    private String toJson(T element) {
        return adapter.toJsonRemovingFields(element, "id");
    }

    private PageRequest createPageableFrom(QueryFilter<DTO> queryElastic) {
        Pageable pageable = Try.of(() -> Pageable.from(queryElastic))
                .getOrElse(Pageable::defaultPageable);

        return PageRequest.of(pageable.getFrom(), pageable.getSize());
    }

    private Try<UpdateResponse> handleJsonError(IllegalArgumentException err) {
        return Try.failure(err);
    }

    private Try<UpdateResponse> handleElasticsearchError(ElasticsearchStatusException err) {
        return Try.failure(err);
    }

    private Try<UpdateResponse> handleUpdateError(IOException err) {
        return Try.failure(err);
    }

    private Try<UpdateResponse> handleUnexpectedError(Throwable err) {
        return Try.failure(err);
    }

    protected BoolQueryBuilder addParametersForQueryBuilder(Map<String, Object> parametersForQuery) {
        BoolQueryBuilder boolQuery = boolQuery();

        parametersForQuery.keySet().forEach(key ->
                boolQuery.should(termsQuery(key, parametersForQuery.get(key))));

        return boolQuery;
    }

    protected Map<String, Object> filterNullValues(Map<String, Object> parameters) {
        return parameters.entrySet().stream()
                .filter(key -> Objects.nonNull(key.getValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    protected abstract Map<String, Object> createParametersFrom(DTO dto);

    protected abstract T elementForSaveFrom(DTO dto);

    protected abstract T elementForUpdateFrom(DTO dto);

    protected abstract String index();

    protected abstract GenericElasticsearchRepository<T> repository();

    protected abstract Class<T> entity();

}
