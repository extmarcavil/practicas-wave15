package com.meli.elasticsearch.exception;

public class ElasticElementNotFoundException extends RuntimeException {

    public <ID> ElasticElementNotFoundException(ID id) {
        super(String.format("Element with ID %s wasn't found", id));
    }
}
