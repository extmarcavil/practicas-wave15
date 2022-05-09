package com.sprint1.be_java_hisp_w15_g4.exception;

public class BadOrderArgumentExcepcion extends RuntimeException {
    public BadOrderArgumentExcepcion(String message) {
        super("El parametro de ordemiento es incorrecto: " + message);
    }
}
