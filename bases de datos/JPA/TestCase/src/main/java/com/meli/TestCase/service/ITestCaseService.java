package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos(LocalDate date);
    TestCase obtenerPorId(Long id);
    void eliminarPorId(Long id);
    ResPostTestDto modificar(Long id, ReqTestCaseDto testMod);
}
