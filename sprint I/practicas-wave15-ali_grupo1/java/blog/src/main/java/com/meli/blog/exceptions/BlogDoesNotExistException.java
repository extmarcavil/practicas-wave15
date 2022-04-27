package com.meli.blog.exceptions;

public class BlogDoesNotExistException extends ApiException {

    public BlogDoesNotExistException(Long id) {
        super(String.format("Blog with ID %s does not exist.", id));
    }

    @Override
    public int getErrorCode() {
        return 404;
    }
}
