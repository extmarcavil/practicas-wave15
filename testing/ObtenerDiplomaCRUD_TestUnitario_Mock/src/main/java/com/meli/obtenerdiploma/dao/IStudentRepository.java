package com.meli.obtenerdiploma.dao;

import com.meli.obtenerdiploma.dao.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
