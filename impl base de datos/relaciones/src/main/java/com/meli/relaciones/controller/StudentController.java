package com.meli.relaciones.controller;

import com.meli.relaciones.dto.StudentDto;
import com.meli.relaciones.service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDto> newStudent (@RequestBody StudentDto studentDto){
        return ResponseEntity.ok().body(service.saveStudent(studentDto));
    }
}
