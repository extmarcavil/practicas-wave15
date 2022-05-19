package com.meli.relaciones.service;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Student;

public interface StudentService {
    StudentDTO save(Student student);
}
