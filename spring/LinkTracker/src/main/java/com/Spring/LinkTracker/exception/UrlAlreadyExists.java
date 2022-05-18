package com.Spring.LinkTracker.exception;

public class UrlAlreadyExists extends RuntimeException{

    public UrlAlreadyExists(String url){
        super("La URL: " + url + " ya existe.");
    }
}
