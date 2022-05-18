package com.Spring.LinkTracker.exception;

public class LinkAlreadyInvalidated extends RuntimeException{

    public LinkAlreadyInvalidated(Integer id){
        super("No se puede invalidar un link ya invalido");
    }

}
