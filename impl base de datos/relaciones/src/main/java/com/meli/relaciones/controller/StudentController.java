package com.meli.relaciones.controller;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    StudentService service;

    public StudentController(StudentService serv) {
        this.service = serv;
    }

    @PostMapping("/student/save")
    public ResponseEntity<Student> newCart(@RequestBody StudentDTO stu) {
        return ResponseEntity.ok(service.save(stu));
    }
}
