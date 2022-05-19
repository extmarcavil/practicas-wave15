package com.meli.relaciones.controller;

import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    ResponseEntity<StudentDto> newStudent(@RequestBody StudentDto newStudent){
        return ResponseEntity.ok(studentService.save(newStudent));
    }
}
