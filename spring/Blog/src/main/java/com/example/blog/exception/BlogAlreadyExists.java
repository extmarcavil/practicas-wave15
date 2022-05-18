package com.example.blog.exception;

public class BlogAlreadyExists extends RuntimeException{

    public BlogAlreadyExists(Integer id){super("El Blog: " + id + " ya existe.");}

}
