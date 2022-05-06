package com.mercadolibre.bootcamp.deportista.service;


import java.util.List;


public interface ICRUDService<T, K> {

    public K save(T obj);

    public List<K> findAll();

    public K findByName(String name);

}
