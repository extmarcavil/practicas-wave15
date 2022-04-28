package com.sprint1.be_java_hisp_w15_g4.exception;

public class BadOrderArgumentException extends RuntimeException{

    public BadOrderArgumentException(String order) {
        super("El parametro de ordemiento es incorrecto: " + order);
    }

}
