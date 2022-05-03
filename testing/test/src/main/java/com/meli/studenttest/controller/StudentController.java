package com.meli.studenttest.controller;

import com.meli.studenttest.dto.request.RequestStudentDto;
import com.meli.studenttest.dto.response.ResponseStudentDto;
import com.meli.studenttest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "average")
    public ResponseStudentDto studentAverage(@Valid @RequestBody RequestStudentDto studentDto) {
        return studentService.calculateAverage(studentDto);
    }

    @PutMapping(value = "update")
    public ResponseEntity<Void> updateStudent(@Valid @RequestBody ResponseStudentDto studentDto) {
        studentService.update(studentDto);
        return ResponseEntity.noContent().build();
    }

}
