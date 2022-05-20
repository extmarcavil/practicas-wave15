package com.meli.relaciones.service;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.repository.ICoursesRepository;
import com.meli.relaciones.repository.IStudentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
    IStudentsRepository repoStudents;
    ICoursesRepository repoCourses;
    ModelMapper mapper;

    public StudentService(IStudentsRepository repo, ICoursesRepository repoCourses) {
        this.repoStudents = repo;
        this.repoCourses = repoCourses;
        mapper = new ModelMapper();
    }

    @Override
    public Student save(StudentDTO stu) {
        Student student = new Student();
        stu.getCourses().forEach(c -> student.addCourse(repoCourses.findById(c).orElse(repoCourses.save(new Course(c)))));
        student.getCourses().forEach(c -> c.addStudent(student));
        return repoStudents.save(student);
    }
}
