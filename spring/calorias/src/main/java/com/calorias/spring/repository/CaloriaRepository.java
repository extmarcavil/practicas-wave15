package com.calorias.spring.repository;

import com.calorias.spring.modelo.Ingrediente;

import java.util.List;

public interface CaloriaRepository {

     List<Ingrediente> loadDataBase ();
}
