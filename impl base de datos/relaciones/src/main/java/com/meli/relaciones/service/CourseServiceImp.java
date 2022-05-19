package com.meli.relaciones.service;

import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.CourseRepository;
import com.meli.relaciones.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService {
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    public CourseServiceImp(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentDto saveCourse(StudentDto studentDto) {

        ModelMapper model = new ModelMapper();

        Student student = model.map(studentDto, Student.class);
        student.getCourses().forEach((i) -> courseRepository.save(i));
        student.getCourses().forEach((i) -> i.addStudents(student));
        Student student1 = studentRepository.save(student);
        StudentDto response = model.map(student1, StudentDto.class);
        return response;
    }
}
