package com.meli.relaciones.service;

import com.meli.relaciones.dto.CartDto;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Cart;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.ICourseRepository;
import com.meli.relaciones.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements IStudentService {

    IStudentRepository repoStudent;
    ICourseRepository repoCourse;

    public StudentServiceImp(IStudentRepository repoStudent, ICourseRepository repoCourse){
        this.repoStudent = repoStudent;
        this.repoCourse = repoCourse;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        ModelMapper model = new ModelMapper();

        Student student = model.map(studentDto,Student.class);
        student.getCourses().forEach((i)-> i.getStd().add(student));
        Student student2 = repoStudent.save(student);

        StudentDto response = model.map(student2,StudentDto.class);
        return response;
    }
}
