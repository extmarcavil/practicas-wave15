package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos();
    TestCase obtenerPorId(Long id);

    List<TestCase>  obtenerPorFecha(String lastUpdate);

    String updateTest(Long id, ReqTestCaseDto test);

    String deleteTest(Long id);
}
