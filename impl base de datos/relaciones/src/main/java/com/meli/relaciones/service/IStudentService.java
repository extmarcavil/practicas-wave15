package com.meli.relaciones.service;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Student;

public interface IStudentService {
    StudentDTO save(StudentDTO student);
}
