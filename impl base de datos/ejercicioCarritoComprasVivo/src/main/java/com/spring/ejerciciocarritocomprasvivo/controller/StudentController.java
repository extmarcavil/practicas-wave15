package com.spring.ejerciciocarritocomprasvivo.controller;

import com.spring.ejerciciocarritocomprasvivo.dto.StudentDTO;
import com.spring.ejerciciocarritocomprasvivo.service.ICourseService;
import com.spring.ejerciciocarritocomprasvivo.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final IStudentService studentService;
    private final ICourseService courseService;

    public StudentController(IStudentService studentService, ICourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDTO> newStudent(@RequestBody StudentDTO studentDTO) {
        //studentDTO.getCourses().forEach(courseDTO -> courseService.saveCourse(courseDTO));
        return new ResponseEntity<>(studentService.saveStudent(studentDTO), HttpStatus.OK);
    }
}
