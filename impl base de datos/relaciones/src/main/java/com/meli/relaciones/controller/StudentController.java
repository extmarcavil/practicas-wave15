package com.meli.relaciones.controller;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@RestController
public class StudentController {

    private IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<StudentDTO> saveStudent (@RequestBody StudentDTO student) {
        return ResponseEntity.ok().body(service.save(student));
    }
}
