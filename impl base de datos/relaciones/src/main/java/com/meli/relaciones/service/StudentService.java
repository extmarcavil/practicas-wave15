package com.meli.relaciones.service;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.CourseRepository;
import com.meli.relaciones.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{

    private StudentRepository repoStudent;
    private CourseRepository repoCourse;
    private ModelMapper mapper;

    public StudentService(StudentRepository repoStudent, CourseRepository repoCourse) {
        this.repoStudent = repoStudent;
        this.repoCourse = repoCourse;
        this.mapper = new ModelMapper();
    }

    @Override
    public StudentDTO save(StudentDTO student) {
        Student studentForDB = mapper.map(student, Student.class);
        System.out.println("------> student: " + student);
        System.out.println("------> studentForDB: " + studentForDB);
        studentForDB.getCourses().forEach(course -> course.getStd().add(studentForDB));

        Student result = repoStudent.save(studentForDB);
        StudentDTO response = mapper.map(result, StudentDTO.class);


        return response;
    }
}
