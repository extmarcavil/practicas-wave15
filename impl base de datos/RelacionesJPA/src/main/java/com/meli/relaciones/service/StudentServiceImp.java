package com.meli.relaciones.service;

import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentServiceImp implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        ModelMapper modelMapper = new ModelMapper();
        Student newStudent = modelMapper.map(studentDto, Student.class);
        //newStudent.getCourses().forEach(c -> c.getStd().add(newStudent));
        Student studentSaved = studentRepository.save(newStudent);
        StudentDto response = modelMapper.map(studentSaved, StudentDto.class);
        return response;
    }
}
