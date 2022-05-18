package com.meli.TestCase.service;

import com.meli.TestCase.dto.ReqTestCaseDto;
import com.meli.TestCase.dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos();
    TestCase obtenerPorId(Long id);
    TestCase actualizarPorId(ReqTestCaseDto testCase, Long id);
    void borrarPorId(Long id);
    List<TestCase> buscarPorFecha(LocalDate localDate);

}
