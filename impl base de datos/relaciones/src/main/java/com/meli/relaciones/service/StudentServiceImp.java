package com.meli.relaciones.service;

import com.meli.relaciones.dto.CourseDto;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.CourseRepository;
import com.meli.relaciones.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentServiceImp implements StudentService {

    StudentRepository studentRepository;
    CourseRepository courseRepository;

    public StudentServiceImp(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        ModelMapper model = new ModelMapper();

        Set<CourseDto> courses = studentDto.getCourses();
        for (CourseDto c : courses)
            courseRepository.findById(c.getId()).orElseThrow(() -> new RuntimeException("No existe el curso"));

        Student student = model.map(studentDto, Student.class);
        Student studentSaved = studentRepository.save(student);

        return model.map(studentSaved, StudentDto.class);
    }
}
