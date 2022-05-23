package com.meli.elasticsearch.elastic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Getter
public class ElasticQueryFilter<T> implements QueryFilter<T> {

    @Nullable
    @Min(1)
    private final Integer size;

    @Nullable
    @PositiveOrZero
    private final Integer from;

    @NotNull
    private final T value;

}
