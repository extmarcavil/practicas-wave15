package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.List;

public class ObtenerDiplomaServiceUtils {
    public  static StudentDTO studentEmpty(){
        return  new StudentDTO();
    }

    public  static List<SubjectDTO> listSubjects(){
        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(new SubjectDTO("Matematicas",9.0));
        listSubjects.add(new SubjectDTO("Español",9.0));
        return  listSubjects;
    }

}
