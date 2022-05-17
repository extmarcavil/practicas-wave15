package com.bootcamp.ejemplo_jpa.controller;

import com.bootcamp.ejemplo_jpa.model.Student;
import com.bootcamp.ejemplo_jpa.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.rmi.StubNotFoundException;
import java.util.List;

@RestController
public class Controller {

    private final IStudentService stuServ;

    public Controller(IStudentService stuServ) {
        this.stuServ = stuServ;
    }

    @PostMapping("/create")
    public  String createStudent(@RequestBody Student student) {
        stuServ.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents () {
        List<Student> studentList = stuServ.getStudents();
        return studentList;
    }

    @PostMapping("edit/{id}")
    public  Student editStudent (@PathVariable long id,
                                 @RequestParam ("name") String  newName,
                                 @RequestParam ("lastname") String newLastname) {
        Student stu = stuServ.findStudent(id);
        stu.setName(newName);
        stu.setLastname(newLastname);
        stuServ.saveStudent(stu);
        return stu;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent ( @PathVariable long id) {
        stuServ.deleteStudent(id);
        return "El esudiante fue borrado correctamente";
    }
}
