package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.SubjectDTO;

public class SubjectFactory {

    public static SubjectDTO getMatematica(){
        SubjectDTO matematica = new SubjectDTO();
        matematica.setName("Matemática");
        matematica.setScore(9.0);
        return matematica;
    }

    public static SubjectDTO getFisica(){
        SubjectDTO fisica = new SubjectDTO();
        fisica.setName("Física");
        fisica.setScore(7.0);
        return fisica;
    }

    public static SubjectDTO getQuimica(){
        SubjectDTO quimica = new SubjectDTO();
        quimica.setName("Química");
        quimica.setScore(6.0);
        return quimica;
    }

    public static SubjectDTO getIngles(){
        SubjectDTO ingles = new SubjectDTO();
        ingles.setName("Inglés");
        ingles.setScore(8.0);
        return ingles;
    }

    public static SubjectDTO getLengua(){
        SubjectDTO lengua = new SubjectDTO();
        lengua.setName("Lengua");
        lengua.setScore(10.0);
        return lengua;
    }
}
