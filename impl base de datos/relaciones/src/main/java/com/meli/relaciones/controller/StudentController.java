package com.meli.relaciones.controller;

import com.meli.relaciones.dto.CartDto;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.entities.Course;
import com.meli.relaciones.service.IStudentService;
import com.meli.relaciones.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping("/student/save")
    public ResponseEntity<StudentDto> newStudent(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok().body(service.saveStudent(studentDto));
    }


}
