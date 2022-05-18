package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos();
    TestCase obtenerPorId(Long id);
    TestCase actualizar(Long id, ReqTestCaseDto test);
    boolean eliminar(Long id);
    List<TestCase> obtenerPorFecha(LocalDate date);
    
}
