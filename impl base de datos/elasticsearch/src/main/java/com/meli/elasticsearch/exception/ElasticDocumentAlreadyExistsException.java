package com.meli.elasticsearch.exception;

public class ElasticDocumentAlreadyExistsException extends RuntimeException {

    public ElasticDocumentAlreadyExistsException(String id) {
        super(String.format("Document entity with ID %s already exists.", id));
    }
}
