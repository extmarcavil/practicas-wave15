package com.meli.relaciones.controller;

import com.meli.relaciones.dto.StudentDTO;
import com.meli.relaciones.entities.Student;
import com.meli.relaciones.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/new")
    public ResponseEntity<StudentDTO> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }
}
