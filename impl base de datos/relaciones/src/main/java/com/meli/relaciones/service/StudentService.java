package com.meli.relaciones.service;

import com.meli.relaciones.dto.CartDto;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Cart;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.CourseRepository;
import com.meli.relaciones.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    StudentRepository repository;


    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        ModelMapper model = new ModelMapper();

        Student student = model.map(studentDto,Student.class);
        Student s = repository.save(student);
        StudentDto response = model.map(s, StudentDto.class);

        return response;
    }


}
