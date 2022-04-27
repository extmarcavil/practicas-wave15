package com.meli.blog.exceptions;

import com.meli.blog.model.Blog;

public class BlogAlreadyExistsException extends ApiException {

    public BlogAlreadyExistsException(Blog blog) {
        super(String.format("%s already exists.", blog));
    }

    @Override
    public int getErrorCode() {
        return 409;
    }
}
