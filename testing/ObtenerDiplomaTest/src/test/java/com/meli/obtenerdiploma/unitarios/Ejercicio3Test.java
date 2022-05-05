package com.meli.obtenerdiploma.unitarios;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.meli.obtenerdiploma.utilidades.Utils.newStudent;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class Ejercicio3Test {
    @Mock
    IStudentDAO sdao;

    @Mock
    IStudentRepository repo;

    @InjectMocks
    StudentService service;

    @Test
    void agregarUnAlumnoTest() {
        StudentDTO student = newStudent(1l, "jose");
        service.create(student);
        //Mockito.doNothing().when(sdao).save(any(StudentDTO.class));
        Mockito.verify(sdao, Mockito.times(1)).save(any(StudentDTO.class));
        //Mockito.verify(sdao, Mockito.atLeast(1)).findById(any(Long.class));
    }

    @Test
    void buscarUnAlumnoTest() {
        StudentDTO student = newStudent(1l, "jose");

        Mockito.when(sdao.findById(1l)).thenReturn(student);

        service.read(1l);

        Mockito.verify(sdao, Mockito.times(1)).findById(any(Long.class));
    }

    //no sigo testeando porque lo unico que hace el servicio es ser un pasamanos (middleMan)
}