package com.meli.TestCase.service;

import com.meli.TestCase.Dto.ReqTestCaseDto;
import com.meli.TestCase.Dto.ResPostTestDto;
import com.meli.TestCase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResPostTestDto guardar(ReqTestCaseDto test);
    List<TestCase> obtenerTodos(String last_update);
    TestCase obtenerPorId(Long id);

    ResPostTestDto updateCase(Long id, ReqTestCaseDto test);

    String deleteCase(Long id);
}
