package com.apiedad.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService  implements  IEdadService{

    @Override
    public int obtenerEdad(int dia, int mes, int anio) throws Exception {
        int Edad = 0;
        try{
            if(mes > 12)
                throw  new Exception("El mes es invalido");

            var dateEdad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
            Edad =  dateEdad.getYears();
        }
        catch (Exception e){
            throw  e;
        }
        return  Edad;
    }
}
