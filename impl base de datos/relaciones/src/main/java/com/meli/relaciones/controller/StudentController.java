package com.meli.relaciones.controller;

import com.meli.relaciones.dto.CartDto;
import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.service.CartService;
import com.meli.relaciones.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/student/save")
    public ResponseEntity<StudentDto> newCart (@RequestBody StudentDto studentDto){
        return ResponseEntity.ok().body(service.saveStudent(studentDto));
    }
}
