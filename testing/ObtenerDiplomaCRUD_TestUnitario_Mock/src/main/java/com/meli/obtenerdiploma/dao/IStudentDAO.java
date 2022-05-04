package com.meli.obtenerdiploma.dao;

import com.meli.obtenerdiploma.dao.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}