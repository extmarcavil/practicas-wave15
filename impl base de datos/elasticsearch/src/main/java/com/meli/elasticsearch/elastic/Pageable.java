package com.meli.elasticsearch.elastic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pageable {

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_FROM = 0;

    private final int size;
    private final int from;

    public static <DTO> Pageable from(QueryFilter<DTO> queryElastic) {
        return new Pageable(queryElastic.getSize(), queryElastic.getFrom());
    }

    public static Pageable defaultPageable() {
        return new Pageable(DEFAULT_SIZE, DEFAULT_FROM);
    }

}
