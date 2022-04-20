package com.apiedad.services;

import org.springframework.stereotype.Service;

@Service
public interface IEdadService {
    int obtenerEdad(int dia,int mes,int anio) throws Exception;
}
