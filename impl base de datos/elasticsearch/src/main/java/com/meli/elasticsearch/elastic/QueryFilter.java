package com.meli.elasticsearch.elastic;

public interface QueryFilter<T> {

    Integer getSize();

    Integer getFrom();

    T getValue();

}
