package com.sprint.be_java_hisp_w15_g10.Exception;

public class CategoryNotFoundPostException extends RuntimeException{
    public CategoryNotFoundPostException(String message){
        super(message);
    }
}
